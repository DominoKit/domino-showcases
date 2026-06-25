#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"
DIST_DIR="${ROOT_DIR}/.dist"
DEFAULT_DEPLOY_ENV_FILE="${ROOT_DIR}/.env"
LEGACY_DEPLOY_ENV_FILE="${SCRIPT_DIR}/deploy.env"

SSH_ARGS=()
REMOTE_HOST=""
DEPLOY_RESTART_SERVICES=""
BUILD_ARGS=()

print_step() {
  printf '==> %s\n' "$*"
}

require_command() {
  if ! command -v "$1" >/dev/null 2>&1; then
    printf 'Required command not found: %s\n' "$1" >&2
    exit 1
  fi
}

load_deploy_env_file() {
  local env_file="${DEPLOY_ENV_FILE:-${DEFAULT_DEPLOY_ENV_FILE}}"
  if [[ ! -f "${env_file}" && -f "${LEGACY_DEPLOY_ENV_FILE}" ]]; then
    env_file="${LEGACY_DEPLOY_ENV_FILE}"
  fi
  if [[ -f "${env_file}" ]]; then
    set -a
    # shellcheck disable=SC1090
    source "${env_file}"
    set +a
  fi
}

prepare_deploy_env() {
  require_command ssh
  require_command rsync

  load_deploy_env_file

  : "${DEPLOY_HOST:?Set DEPLOY_HOST or provide it in .env}"
  : "${DEPLOY_USER:?Set DEPLOY_USER or provide it in .env}"

  DEPLOY_SSH_PORT="${DEPLOY_SSH_PORT:-22}"
  DEPLOY_REMOTE_BASE_DIR="${DEPLOY_REMOTE_BASE_DIR:-/opt/domino-showcases}"
  DEPLOY_REMOTE_DIST_DIR="${DEPLOY_REMOTE_DIST_DIR:-${DEPLOY_REMOTE_BASE_DIR}/.dist}"
  DEPLOY_REMOTE_COMPOSE_FILE="${DEPLOY_REMOTE_COMPOSE_FILE:-${DEPLOY_REMOTE_BASE_DIR}/docker-compose.yml}"
  DEPLOY_SKIP_BUILD="${DEPLOY_SKIP_BUILD:-false}"
  DEPLOY_RESTART_SERVICES="${DEPLOY_RESTART_SERVICES:-true}"

  SSH_ARGS=(-p "${DEPLOY_SSH_PORT}")
  if [[ -n "${DEPLOY_SSH_KEY_FILE:-}" ]]; then
    SSH_ARGS+=(-i "${DEPLOY_SSH_KEY_FILE}")
  fi

  REMOTE_HOST="${DEPLOY_USER}@${DEPLOY_HOST}"
}

parse_deploy_args() {
  BUILD_ARGS=()

  while (($#)); do
    case "$1" in
      --no-restart)
        DEPLOY_RESTART_SERVICES="false"
        ;;
      --restart)
        DEPLOY_RESTART_SERVICES="true"
        ;;
      *)
        BUILD_ARGS+=("$1")
        ;;
    esac
    shift
  done
}

build_if_needed() {
  local build_script="$1"
  if [[ "${DEPLOY_SKIP_BUILD}" == "true" ]]; then
    print_step "Skipping local build because DEPLOY_SKIP_BUILD=true"
    return
  fi

  bash "${build_script}" "${BUILD_ARGS[@]}"
}

load_release_metadata() {
  local app_id="$1"
  local release_file="${DIST_DIR}/${app_id}/release.env"

  if [[ ! -f "${release_file}" ]]; then
    printf 'Missing staged distribution metadata: %s\n' "${release_file}" >&2
    exit 1
  fi

  unset APP_ID MODULE_DIR IMAGE_NAME SERVICE_NAME CONTAINER_PORT
  # shellcheck disable=SC1090
  source "${release_file}"
}

rsync_rsh() {
  local args=(ssh "${SSH_ARGS[@]}")
  printf '%q ' "${args[@]}"
}

sync_app_distribution() {
  local app_id="$1"
  local remote_app_dir="${DEPLOY_REMOTE_DIST_DIR}/${app_id}"

  print_step "Syncing ${app_id} distribution to ${REMOTE_HOST}:${remote_app_dir}"
  ssh "${SSH_ARGS[@]}" "${REMOTE_HOST}" mkdir -p "${remote_app_dir}"
  rsync -az --delete -e "$(rsync_rsh)" \
    "${DIST_DIR}/${app_id}/" \
    "${REMOTE_HOST}:${remote_app_dir}/"
}

rebuild_remote_app() {
  local app_id="$1"
  local remote_app_dir="${DEPLOY_REMOTE_DIST_DIR}/${app_id}"
  local restart_action=""

  load_release_metadata "${app_id}"
  if [[ "${DEPLOY_RESTART_SERVICES}" == "true" ]]; then
    restart_action="and restarting ${SERVICE_NAME}"
  else
    restart_action="without restarting ${SERVICE_NAME}"
  fi

  print_step "Rebuilding ${IMAGE_NAME} ${restart_action} on ${REMOTE_HOST}"
  ssh "${SSH_ARGS[@]}" "${REMOTE_HOST}" bash -s -- \
    "${remote_app_dir}" \
    "${IMAGE_NAME}" \
    "${SERVICE_NAME}" \
    "${DEPLOY_REMOTE_COMPOSE_FILE}" \
    "${DEPLOY_RESTART_SERVICES}" <<'EOF'
set -euo pipefail

remote_app_dir="$1"
image_name="$2"
service_name="$3"
compose_file="$4"
restart_services="$5"

if [[ ! -d "${remote_app_dir}" ]]; then
  printf 'Remote distribution directory is missing: %s\n' "${remote_app_dir}" >&2
  exit 1
fi

if [[ ! -f "${compose_file}" ]]; then
  printf 'Remote docker compose file is missing: %s\n' "${compose_file}" >&2
  exit 1
fi

docker build \
  --label domino.showcases.repo=domino-showcases \
  --label "domino.showcases.app=${service_name}" \
  -t "${image_name}" \
  "${remote_app_dir}"

compose_dir="$(dirname "${compose_file}")"
compose_name="$(basename "${compose_file}")"

if [[ "${restart_services}" == "true" ]]; then
  cd "${compose_dir}"
  if docker compose version >/dev/null 2>&1; then
    docker compose -f "${compose_name}" up -d --force-recreate --no-deps "${service_name}"
  else
    docker-compose -f "${compose_name}" up -d --force-recreate --no-deps "${service_name}"
  fi
else
  printf 'Skipping service restart for %s\n' "${service_name}"
fi

docker image prune -af --filter label=domino.showcases.repo=domino-showcases
EOF
}

deploy_app() {
  local app_id="$1"
  sync_app_distribution "${app_id}"
  rebuild_remote_app "${app_id}"
}
