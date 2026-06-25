# Deployment

This document describes how to deploy `domino-site` and `domino-demo` using the scripts in `scripts/`.

## What The Deploy Scripts Do

The deploy scripts:

1. Build the application locally unless `DEPLOY_SKIP_BUILD=true`.
2. Stage deployment artifacts under `.dist/`.
3. Copy `.dist/` to the remote server with `rsync`.
4. Build the Docker images on the remote server.
5. Restart the Docker Compose services unless restart is disabled.
6. Prune old labeled showcase images on the remote server.

The current image names are:

- `website:latest` for `domino-site`
- `demo:v2` for `domino-demo`

## Prerequisites

The local machine needs:

- Java 17
- Maven
- `ssh`
- `rsync`

The remote server needs:

- Docker
- `docker compose` or `docker-compose`
- The compose file at the configured path
- An SSH user that can run Docker commands without `sudo`

## One-Time Setup

1. Edit the root `.env` file.
2. Replace the placeholder values with the real server details.
3. At minimum set `DEPLOY_HOST` and `DEPLOY_USER`.
4. Set `DEPLOY_SSH_PORT`, `DEPLOY_SSH_KEY_FILE`, `DEPLOY_REMOTE_BASE_DIR`, `DEPLOY_REMOTE_DIST_DIR`, and `DEPLOY_REMOTE_COMPOSE_FILE` if needed.
5. If your remote compose uses `GITHUB_APP_PRIVATE_KEY_FILE=/tmp/github-app.pem` for `domino-site`, set `SITE_GITHUB_APP_PEM_FILE` to the local PEM path so it is bundled into the image during staging.

Example:

```env
DEPLOY_HOST=your-server
DEPLOY_USER=ubuntu
DEPLOY_SSH_KEY_FILE=/home/you/.ssh/id_ed25519
DEPLOY_REMOTE_BASE_DIR=/home/ubuntu/apps/domino-showcases
DEPLOY_REMOTE_DIST_DIR=/home/ubuntu/apps/domino-showcases/.dist
DEPLOY_REMOTE_COMPOSE_FILE=/home/ubuntu/apps/domino-showcases/docker-compose.yml
SITE_GITHUB_APP_PEM_FILE=/home/you/secrets/github-app.pem
```

## Standard Deployment

Deploy both apps:

```bash
./scripts/deploy-all.sh
```

Deploy only the site:

```bash
./scripts/deploy-site.sh
```

Deploy only the demo:

```bash
./scripts/deploy-demo.sh
```

## Deploy Without `domino-ui-pro`

Deploy both apps without `domino-ui-pro`:

```bash
./scripts/deploy-all.sh -Dinclude.domino.ui.pro=false
```

Deploy only one app without `domino-ui-pro`:

```bash
./scripts/deploy-site.sh -Dinclude.domino.ui.pro=false
./scripts/deploy-demo.sh -Dinclude.domino.ui.pro=false
```

## Copy And Build Without Restarting Services

To copy the new `.dist/` to the remote server and build the images there without restarting the running services:

```bash
./scripts/deploy-all.sh --no-restart
```

You can also use:

```bash
./scripts/deploy-site.sh --no-restart
./scripts/deploy-demo.sh --no-restart
```

The same behavior can be made the default in `.env`:

```env
DEPLOY_RESTART_SERVICES=false
```

## Later Cutover Using Existing `.dist`

If you already copied and built the images remotely and only want to do the final rollout later, reuse the existing local `.dist/` and skip rebuilding locally:

```bash
DEPLOY_SKIP_BUILD=true ./scripts/deploy-all.sh
```

You can combine that with no-pro mode:

```bash
DEPLOY_SKIP_BUILD=true ./scripts/deploy-all.sh -Dinclude.domino.ui.pro=false
```

## Useful Notes

- Local deployment artifacts are staged under `.dist/domino-site` and `.dist/domino-demo`.
- The default remote dist path is `/opt/domino-showcases/.dist`.
- The default remote compose path is `/opt/domino-showcases/docker-compose.yml`.
- The deploy scripts load settings from the root `.env` by default.
- `domino-site` supports either `GITHUB_APP_PRIVATE_KEY` or `GITHUB_APP_PRIVATE_KEY_FILE`. If you use the file-based form, stage the PEM with `SITE_GITHUB_APP_PEM_FILE`.
