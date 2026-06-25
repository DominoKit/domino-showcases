#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# shellcheck source=deploy-lib.sh
source "${SCRIPT_DIR}/deploy-lib.sh"

prepare_deploy_env
parse_deploy_args "$@"
build_if_needed "${SCRIPT_DIR}/build-all.sh"
deploy_app "domino-site"
deploy_app "domino-demo"
