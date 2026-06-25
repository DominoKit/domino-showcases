#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# shellcheck source=dist-lib.sh
source "${SCRIPT_DIR}/dist-lib.sh"

print_step "Building domino-demo modules"
mvn -f "${ROOT_DIR}/pom.xml" -Pdemo -pl domino-demo/domino-demo-backend -am clean package "$@"

mkdir -p "${DIST_DIR}"
stage_demo_distribution

print_step "Distribution staged under ${DIST_DIR}/domino-demo"
