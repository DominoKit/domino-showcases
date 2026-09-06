# Blueprint Individual Screens Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Give all 118 blueprint menu leaves their own Brix presenter and view, with each route rendering one sample only.

**Architecture:** Convert the current 13 category-level route/view pairs into 118 sample-level route/view triplets. The existing blueprint sample classes and shared composition helpers remain in `demo-samples-ui`; each generated UI view wraps only its corresponding sample in `SamplePageView`/`SampleShowcase`. The shell keeps the three-level menu but points leaves to full sample paths.

**Tech Stack:** Java, GWT, Domino UI, Domino Brix, Dagger, Maven, existing showcase modules.

**Spec:** `docs/superpowers/specs/2026-09-06-blueprints-individual-screens-design.md`

## Global Constraints

- Keep the root menu label exactly `Blueprints`.
- Keep exactly 13 blueprint category branches and 118 blueprint leaves.
- Each leaf route must be `blueprints/<category-slug>/<sample-slug>`.
- Every blueprint entry must have one presenter, one view contract, and one `@UiView` implementation.
- Each blueprint UI view must add exactly one `SampleShowcase`.
- Remove category presenters/views so category routes cannot render alongside sample routes.
- Preserve unrelated working-tree changes in the main checkout; all implementation changes stay in the isolated worktree.

## File map

- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java` — replace hash-anchor leaf tokens with full sample routes.
- Delete: the 13 category presenters, 13 category view contracts, and 13 category UI view implementations — eliminate multi-sample category pages.
- Create: 118 presenter classes under `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/`.
- Create: 118 view contracts under `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/`.
- Create: 118 UI view implementations under `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/`.
- Unmodified inputs: the 118 existing `*Sample` classes under `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/`.

### Task 1: Convert the menu to sample routes

**Files:**
- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java`

- [ ] Extract the current 118 leaf labels and their category ownership from the existing menu and view implementations.
- [ ] Replace every `blueprints/<category>#<sample-anchor>` token with `blueprints/<category>/<sample-slug>`.
- [ ] Preserve labels, category order, and the three-level tree structure.
- [ ] Check that all 118 routes are unique and that no leaf still contains `#`.

### Task 2: Generate the individual presenter/view triplets

**Files:**
- Create: 118 presenter classes, one for each existing sample.
- Create: 118 view contracts, one for each existing sample.
- Create: 118 UI view implementations, one for each existing sample.
- Delete: the old 13 category presenter/view/UI implementation files.

- [ ] Derive each Java type name from its existing sample class name, preserving the `*Sample` suffix for the sample and using a matching `*Presenter`/`*View` pair.
- [ ] Give each presenter a route constant matching the full menu route and bind it to `ShellPresenter.CONTENT_SLOT`.
- [ ] Make each view contract follow the existing nested `*UiHandlers` convention.
- [ ] Make each UI view extend `SamplePageView`, use the catalog title and description already present in the category view, add exactly one sample with `addSample(...)`, and call `initPage()`.
- [ ] Keep shared sample classes and helpers untouched unless compilation identifies an existing integration issue.

### Task 3: Verify route registration and rendering structure

**Files:**
- Verify: all created/deleted route and view files.

- [ ] Run source manifest checks for 118 presenters, 118 view contracts, 118 UI views, and 118 `SampleShowcase`/`addSample` bindings.
- [ ] Verify no category-level blueprint presenter or view remains.
- [ ] Compile the affected samples reactor and regenerate Brix/Dagger sources.
- [ ] Start the showcase backend and exercise every third-level route, confirming each route renders one sample and does not show `Failed to render sample.`.
- [ ] Run the existing targeted blueprint tests and any new source manifest checks.
- [ ] Run a package build for the backend artifact.

### Task 4: Integrate and clean up

- [ ] Review the worktree diff for unrelated changes.
- [ ] Commit the implementation on `feature/blueprints-individual-samples`.
- [ ] Merge the feature branch into `main` without disturbing the main checkout’s unrelated dirty files.
- [ ] Re-run verification from the merged main checkout.
- [ ] Remove the feature worktree and delete the merged feature branch, as requested.
