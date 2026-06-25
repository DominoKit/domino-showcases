# domino-demo

DominoKit Brix application scaffold (frontend, backend, shared modules).

## Project structure

- `domino-demo-frontend`: GWT client module and web resources.
- `domino-demo-backend`: Quarkus backend (REST endpoints, static assets).
- `domino-demo-shared`: shared DTOs and utilities used by frontend/backend.
- `.idea/runConfigurations`: optional IDE run configs (if generated).

## Build

Build all modules:

```
mvn clean verify
```

## Run (development)

Start the Quarkus backend in one terminal:

```
mvn compile quarkus:dev -pl domino-demo-backend
```

Start the GWT code server in another terminal:

```
mvn gwt:codeserver -pl domino-demo-frontend -am
```

## Run (production)

Follow the instructions in `domino-demo-backend/README.md` to build and run the backend.

## More info

- Domino Brix: https://www.dominokit.com/solutions/domino-brix
- Domino CLI: https://www.dominokit.com/resources/domino-cli
