#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
ROOT_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"
DIST_DIR="${ROOT_DIR}/.dist"
DEFAULT_DEPLOY_ENV_FILE="${ROOT_DIR}/.env"

print_step() {
  printf '==> %s\n' "$*"
}

load_dist_env_file() {
  local env_file="${DIST_ENV_FILE:-${DEFAULT_DEPLOY_ENV_FILE}}"
  if [[ -f "${env_file}" ]]; then
    set -a
    # shellcheck disable=SC1090
    source "${env_file}"
    set +a
  fi
}

write_dist_dockerfile() {
  local app_dist_dir="$1"
  local container_port="$2"
  local include_github_pem="$3"
  local runtime_profile="${4:-}"

  cat > "${app_dist_dir}/Dockerfile" <<EOF
FROM eclipse-temurin:17-jre-jammy

WORKDIR /tmp

COPY target/quarkus-app/app ./app
COPY target/quarkus-app/lib ./lib
COPY target/quarkus-app/quarkus ./quarkus
COPY target/quarkus-app/quarkus-app-dependencies.txt ./quarkus-app-dependencies.txt
COPY target/quarkus-app/quarkus-run.jar ./quarkus-run.jar
EOF

  if [[ "${include_github_pem}" == "true" ]]; then
    cat >> "${app_dist_dir}/Dockerfile" <<'EOF'
COPY github-app.pem ./github-app.pem
EOF
  fi

  if [[ -n "${runtime_profile}" ]]; then
    cat >> "${app_dist_dir}/Dockerfile" <<EOF
ENV QUARKUS_PROFILE=${runtime_profile}
EOF
  fi

  cat >> "${app_dist_dir}/Dockerfile" <<EOF

EXPOSE ${container_port}

ENTRYPOINT ["java", "-Dquarkus.http.host=0.0.0.0", "-Djava.util.logging.manager=org.jboss.logmanager.LogManager", "-jar", "quarkus-run.jar"]
EOF
}

stage_app_distribution() {
  local app_id="$1"
  local module_dir="$2"
  local image_name="$3"
  local service_name="$4"
  local container_port="$5"
  local github_pem_source_file="${6:-}"
  local runtime_profile="${7:-}"
  local module_root="${ROOT_DIR}/${module_dir}"
  local quarkus_app_dir="${module_root}/target/quarkus-app"
  local app_dist_dir="${DIST_DIR}/${app_id}"
  local include_github_pem="false"

  if [[ ! -d "${quarkus_app_dir}" ]]; then
    printf 'Missing Quarkus application directory: %s\n' "${quarkus_app_dir}" >&2
    exit 1
  fi

  print_step "Staging ${app_id} distribution"
  rm -rf "${app_dist_dir}"
  mkdir -p "${app_dist_dir}/target"

  cp -R "${quarkus_app_dir}" "${app_dist_dir}/target/"

  if [[ -n "${github_pem_source_file}" ]]; then
    if [[ ! -f "${github_pem_source_file}" ]]; then
      printf 'Missing GitHub app PEM file: %s\n' "${github_pem_source_file}" >&2
      exit 1
    fi

    cp "${github_pem_source_file}" "${app_dist_dir}/github-app.pem"
    include_github_pem="true"
  fi

  write_dist_dockerfile "${app_dist_dir}" "${container_port}" "${include_github_pem}" "${runtime_profile}"

  cat > "${app_dist_dir}/release.env" <<EOF
APP_ID=${app_id}
MODULE_DIR=${module_dir}
IMAGE_NAME=${image_name}
SERVICE_NAME=${service_name}
CONTAINER_PORT=${container_port}
EOF
}

stage_site_distribution() {
  load_dist_env_file

  stage_app_distribution \
    "domino-site" \
    "domino-site/domino-site-backend" \
    "website:latest" \
    "dominokit-site" \
    "9292" \
    "${SITE_GITHUB_APP_PEM_FILE:-}"
}

stage_demo_distribution() {
  stage_app_distribution \
    "domino-demo" \
    "domino-demo/domino-demo-backend" \
    "demo:v2" \
    "domino-ui-demo-v2" \
    "8090" \
    "" \
    "remote"
}
