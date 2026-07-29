# Markdown Showcases Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Add the markdown docs section under `resources` and add the markdown sample showcase pages in the site and demo apps.

**Architecture:** The docs section will be a new nested branch under the existing resources templates and will be backed by the current content loader. The markdown sample showcase will use shared sample implementations from `demo-samples/demo-samples-ui-pro`, with thin site and demo wrappers that follow the existing Brix presenter/view patterns.

**Tech Stack:** Java 17, Maven, Quarkus, Thymeleaf templates, Domino Brix, GWT, Domino UI, domino-md, domino-ui-pro.

## Global Constraints

- Keep the showcase styling and template structure consistent with the existing `resources`, solution docs, and sample pages.
- Do not modify the external `domino-md` repo.
- Reuse the shared sample pattern already used by the showcase repo for pro-only UI pieces.
- Preserve the current `resources` landing page behavior unless a change is explicitly needed for the markdown branch.

---

### Task 1: Add markdown resources docs pages

**Files:**
- Modify: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/resources-menu.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/resources/markdown.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/getting-started.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/getting-started/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/getting-started/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/parsing-and-asts.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/parsing-and-asts/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/parsing-and-asts/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/rendering.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/rendering/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/rendering/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/extensions.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/extensions/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/extensions/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/configuration.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/configuration/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/configuration/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/examples.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/examples/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/examples/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/api-reference.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/api-reference/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/api-reference/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/cookbook.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/cookbook/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/resources/markdown/cookbook/body.html`

**Interfaces:**
- Consumes: `LoadContentResource` page-path lookup, existing `resources-menu.html`, existing site docs fragments.
- Produces: nested markdown docs pages reachable under `/resources/markdown/...`.

- [ ] **Step 1: Write the markdown resources menu branch**

Use the existing `dui-site-docs-menu` / `dui-site-docs-sub-menu` structure so `Markdown` appears as a parent entry with the new pages underneath it.

- [ ] **Step 2: Add the markdown landing page and child page templates**

Create a thin wrapper per page that follows the existing `resources/domino-cli` and `resources/widget-element-integration` template pattern.

- [ ] **Step 3: Author the page content**

Write concise website-style documentation for each topic, based on the corresponding `domino-md/docs` material.

- [ ] **Step 4: Verify the resource routes render**

Run the site backend and open `/resources/markdown` plus a few child pages to confirm the templates resolve.

### Task 2: Add shared markdown sample implementations

**Files:**
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/MarkdownSamples.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/MarkdownScenarioPage.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/AbstractMarkdownScenarioPage.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/StandaloneEditorMarkdownSample.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/StandalonePreviewMarkdownSample.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/SplitBindingMarkdownSample.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/CustomBindingMarkdownSample.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/PlaygroundMarkdownSample.java`
- Create: `demo-samples/demo-samples-ui-pro/src/main/java/org/dominokit/showcases/samples/markdown/ClassStylingMarkdownSample.java`

**Interfaces:**
- Consumes: `MarkdownEditor`, `MarkdownPreview`, `SplitMarkdownEditor`, `MarkdownEditorConfig`, `MarkdownPreviewConfig`, `SplitMarkdownEditorConfig`, `SplitMode`, `MarkdownClassExtension`, `DominoMarkdownRenderer`.
- Produces: reusable markdown sample components for both the site and the demo app.

- [ ] **Step 1: Port the reference markdown scenarios into shared sample classes**

Model the scenario content and controls after the temp sample app, but keep the styling and component composition consistent with the repository's other shared samples.

- [ ] **Step 2: Keep the helper surface reusable**

Use one shared markdown content helper and one abstract page base so the site and demo wrappers only need to register the samples.

- [ ] **Step 3: Verify the shared module compiles**

Run the `demo-samples-ui-pro` module compile path before wiring wrappers.

### Task 3: Wire markdown samples into the site docs

**Files:**
- Create: `domino-site/pages/pages-frontend-pro/src/main/java/org/dominokit/pages/presenters/samples/components/MarkdownProxy.java`
- Create: `domino-site/pages/pages-ui-pro/src/main/java/org/dominokit/pages/ui/views/samples/components/markdown/MarkdownViewImpl.java`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/solutions/domino-ui/v2/docs/components/markdown/body.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/solutions/domino-ui/v2/docs/components/markdown/main.html`
- Create: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/solutions/domino-ui/v2/docs/components/markdown/markdown.html`
- Modify: `domino-site/domino-site-backend/src/main/resources/dominokitsite/templates/pages/solutions/domino-ui/v2/domino-ui-menu.html`

**Interfaces:**
- Consumes: shared markdown sample classes from `demo-samples-ui-pro`, existing `SampleProxy`, existing `SampleViewImpl`.
- Produces: a new markdown component docs page under `/solutions/domino-ui/v2/docs/components/markdown`.

- [ ] **Step 1: Add the site presenter route**

Register the markdown page under the component docs tree so it appears in the solution navigation.

- [ ] **Step 2: Add the site sample view**

Register the markdown sample classes with stable sample IDs matching the page sections.

- [ ] **Step 3: Add the markdown docs template**

Build the page body in the same style as `components/menubar` and `components/colorpicker`, including class docs blocks and sample sections.

- [ ] **Step 4: Add the markdown item to the component menu**

Insert a `Markdown` entry in the existing solution docs menu so it sits with the other component docs.

### Task 4: Wire markdown samples into the demo app

**Files:**
- Create: `domino-demo/samples/samples-frontend-pro/src/main/java/org/dominokit/demo/samples/presenters/components/MarkdownPresenter.java`
- Create: `domino-demo/samples/samples-frontend-pro/src/main/java/org/dominokit/demo/samples/views/components/markdown/MarkdownView.java`
- Create: `domino-demo/samples/samples-ui-pro/src/main/java/org/dominokit/demo/samples/ui/views/components/markdown/MarkdownViewImpl.java`
- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java`

**Interfaces:**
- Consumes: shared markdown sample classes, `SamplePageView`, existing shell menu structure.
- Produces: a new demo route under `components/markdown` with markdown samples visible in the shell navigation.

- [ ] **Step 1: Add the demo presenter and view contract**

Define the route and handler surface the same way the existing component pages do.

- [ ] **Step 2: Add the demo view implementation**

Register the shared markdown samples and keep the page copy aligned with the other demo sample pages.

- [ ] **Step 3: Add the shell navigation item**

Insert the markdown entry into the Components tree so it is reachable from the demo sidebar.

### Task 5: Verify and clean up

**Files:**
- Potentially modify any generated or doc resource files required by the first four tasks.

**Interfaces:**
- Consumes: all prior tasks.
- Produces: a buildable showcase repo with the new markdown docs and samples.

- [ ] **Step 1: Run targeted Maven builds**

Verify the affected modules compile before declaring the work done.

- [ ] **Step 2: Smoke-test the routes**

Open the new resources docs page and the markdown sample pages in both apps to confirm the menu and content render.

- [ ] **Step 3: Capture any follow-up fixes**

Address only issues directly introduced by the markdown additions.
