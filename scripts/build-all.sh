#!/usr/bin/env bash

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

# shellcheck source=dist-lib.sh
source "${SCRIPT_DIR}/dist-lib.sh"

print_step "Building all showcase modules"
mvn -f "${ROOT_DIR}/pom.xml" clean package "$@"

print_step "Refreshing .dist directory"
rm -rf "${DIST_DIR}"
mkdir -p "${DIST_DIR}"

stage_site_distribution
stage_demo_distribution

print_step "Distribution staged under ${DIST_DIR}"
