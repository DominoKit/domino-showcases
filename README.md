# Domino Showcases

This repository contains the DominoKit showcase applications:

- `domino-site`: the docs and marketing site.
- `domino-demo`: the interactive sample browser.

It also contains the shared sample library used by both apps and the shared supporting code they build on.

## Repository Structure

- `domino-site`: site application modules.
- `domino-demo`: demo application modules.
- `demo-samples`: shared sample implementations used by both apps where applicable.
- `showcase-shared`: shared resources and common code.
- `scripts`: build and deployment helpers.
- `.dist`: generated deployment-ready Docker build contexts created by the build scripts.

## Optional `domino-ui-pro`

By default, the build includes `domino-ui-pro`.

- Default mode:
- `-Dinclude.domino.ui.pro=true`
- No-pro mode:
- `-Dinclude.domino.ui.pro=false`

Use the default mode if you have access to the private `domino-ui-pro` artifacts. Use the no-pro mode if you do not.

When pro is enabled, the repository builds separate `*-pro` modules for the private samples and wrappers instead of mixing pro code into the base modules. This keeps IntelliJ imports and source roots normal.

## Prerequisites

- Java 17
- Maven
- Access to the private `domino-ui-pro` repository only if you want the default pro-enabled build

## Build

Build everything with `domino-ui-pro` enabled:

```bash
mvn clean verify
```

Build everything without `domino-ui-pro`:

```bash
mvn clean verify -Dinclude.domino.ui.pro=false
```

You can also use the helper scripts:

```bash
./scripts/build-all.sh
./scripts/build-site.sh
./scripts/build-demo.sh
```

Those scripts now stage deployment-ready artifacts under `.dist/`:

- `.dist/domino-site`
- `.dist/domino-demo`

Each app distribution contains:

- `Dockerfile`
- `target/quarkus-app/`
- `release.env`

The staged Dockerfile uses a plain Eclipse Temurin runtime image and copies the packaged Quarkus app directly, matching the simpler deployment style under `temp/Dockerfile`. For `domino-site`, the staging flow can also bundle a local GitHub app PEM into the image as `/tmp/github-app.pem`.

Pass the no-pro flag through the scripts when needed:

```bash
./scripts/build-all.sh -Dinclude.domino.ui.pro=false
./scripts/build-site.sh -Dinclude.domino.ui.pro=false
./scripts/build-demo.sh -Dinclude.domino.ui.pro=false
```

## Run `domino-site`

Development mode uses two terminals.

Backend:

```bash
cd domino-site/domino-site-backend
mvn compile quarkus:dev
```

Frontend code server:

```bash
cd domino-site
mvn gwt:codeserver -pl domino-site-frontend -am -Dgwt.persistentunitcache=false
```

Open:

```text
http://localhost:9292
```

Run `domino-site` without `domino-ui-pro`:

Backend:

```bash
cd domino-site/domino-site-backend
mvn compile quarkus:dev -Dinclude.domino.ui.pro=false
```

Frontend code server:

```bash
cd domino-site
mvn gwt:codeserver -pl domino-site-frontend -am -Dgwt.persistentunitcache=false -Dinclude.domino.ui.pro=false
```

## Run `domino-demo`

Development mode also uses two terminals.

Backend:

```bash
cd domino-demo/domino-demo-backend
mvn compile quarkus:dev
```

Frontend code server:

```bash
cd domino-demo
mvn gwt:codeserver -pl domino-demo-frontend -am -Dgwt.persistentunitcache=false
```

Open:

```text
http://localhost:8090
```

Run `domino-demo` without `domino-ui-pro`:

Backend:

```bash
cd domino-demo/domino-demo-backend
mvn compile quarkus:dev -Dinclude.domino.ui.pro=false
```

Frontend code server:

```bash
cd domino-demo
mvn gwt:codeserver -pl domino-demo-frontend -am -Dgwt.persistentunitcache=false -Dinclude.domino.ui.pro=false
```

## Deploy

The deployment scripts build `.dist/`, sync it to a remote host, rebuild the Docker images there, restart the Docker Compose services, and prune old showcase images.

Supported scripts:

```bash
./scripts/deploy-site.sh
./scripts/deploy-demo.sh
./scripts/deploy-all.sh
```

Remote configuration can be provided with environment variables or through a root `.env` file based on `.env.example`.

Required variables:

- `DEPLOY_HOST`
- `DEPLOY_USER`

Optional variables:

- `DEPLOY_SSH_PORT`
- `DEPLOY_SSH_KEY_FILE`
- `DEPLOY_REMOTE_BASE_DIR`
- `DEPLOY_REMOTE_COMPOSE_FILE`
- `SITE_GITHUB_APP_PEM_FILE`
- `DEPLOY_SKIP_BUILD=true`
- `DEPLOY_RESTART_SERVICES=false`

By default the remote compose file is expected at `/opt/domino-showcases/docker-compose.yml`, and the generated distributions are uploaded under `/opt/domino-showcases/.dist`.

If your remote compose uses `GITHUB_APP_PRIVATE_KEY_FILE=/tmp/github-app.pem`, set `SITE_GITHUB_APP_PEM_FILE` in `.env` so the deploy staging bundles that PEM into the `domino-site` image.

Pass the no-pro flag through the deploy scripts the same way if you need a no-pro distribution:

```bash
./scripts/deploy-all.sh -Dinclude.domino.ui.pro=false
```

To copy the new distribution to the remote host and build the images there without restarting the running Docker services, either set `DEPLOY_RESTART_SERVICES=false` in `.env` or pass `--no-restart` to the deploy script:

```bash
./scripts/deploy-site.sh --no-restart
./scripts/deploy-all.sh --no-restart -Dinclude.domino.ui.pro=false
```

## IntelliJ Run Configurations

Committed run configurations exist under `.idea/runConfigurations`.

- They currently run in the default pro-enabled mode.
- If you want a no-pro IDE run, duplicate the configuration and add:
- `-Dinclude.domino.ui.pro=false`

## Module Overview

### `domino-site`

- `domino-site-backend`: Quarkus backend, templates, docs rendering, static resources.
- `domino-site-frontend`: main GWT app packaged as a webjar.
- `domino-site-shared`: shared contracts and utilities.
- `pages`: site page routing and UI modules.
- `pages-frontend-pro` and `pages-ui-pro`: pro-only site routing and UI modules, included only when `domino-ui-pro` is enabled.

### `domino-demo`

- `domino-demo-backend`: Quarkus backend for the demo app.
- `domino-demo-frontend`: main GWT app packaged as a webjar.
- `domino-demo-shared`: shared contracts and DTOs.
- `shell`: top-level app shell and navigation.
- `samples`: sample presenters, views, and UI components.
- `samples-frontend-pro` and `samples-ui-pro`: pro-only demo routing and UI modules, included only when `domino-ui-pro` is enabled.

### `demo-samples`

- Shared sample implementations used by both applications when a sample should exist in both places.
- `demo-samples-ui-pro`: shared pro-only sample implementations, included only when `domino-ui-pro` is enabled.

### `showcase-shared`

- Shared resources and common code used across the showcase repository.
