# Full Blueprints Catalog Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Implement all 118 catalog entries as named showcase samples under a three-level `Blueprints` menu: root category, blueprint category, and individual blueprint leaf.

**Architecture:** Use 13 category routes, one per catalog section, with each category view rendering its entries through the existing `SamplePageView`/`SampleShowcase` pattern. Every catalog entry gets an independent `*Sample` class, while reusable enterprise compositions—toolbars, filters, tables, forms, drawers, timelines, states, and fixtures—live in shared blueprint helpers. Third-level menu leaves navigate to their category route and identify the selected sample with a URL fragment for deep linking within the category page.

**Tech Stack:** Java 17, GWT, Domino UI, Domino Brix, Dagger, Maven, existing `demo-samples-ui`, `samples-frontend`, `samples-ui`, and shell modules.

**Spec:** `docs/superpowers/specs/2026-09-05-enterprise-screen-blueprints-design.md`

## Global Constraints

- The root menu label is exactly `Blueprints`.
- The menu has exactly three levels: `Blueprints` → one of the 13 catalog categories → one catalog blueprint.
- The catalog contains 118 blueprint entries and every entry must have one independently named `*Sample` class.
- Blueprint samples are domain-neutral compositions and use deterministic local fixtures; no backend API is added for this feature.
- Reuse shared blueprint classes when multiple entries differ only by composition options, but keep every catalog entry as a separate sample class and `SampleShowcase`.
- Follow the existing Brix presenter/view/component conventions for the 13 category routes.
- Preserve unrelated changes already present in the source checkout; implementation occurs only in the isolated worktree.
- Every category page must expose loading, empty, error, read-only, or conflict states where the catalog entry calls for them.
- The existing approved catalog remains the source of truth for names, descriptions, variants, and category membership.

---

## File map

### Shared sample implementation

- Create `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintFixtures.java` for deterministic records, events, files, tasks, bookings, metrics, and state fixtures.
- Create `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintSampleSupport.java` for reusable Domino UI builders: page toolbars, filter chips, record rows, status badges, split panes, activity items, empty/error panels, and action feedback.
- Create `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintSampleKind.java` for the supported composition families and shared copy.
- Create one `*Sample.java` under `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/<category>/` for each of the 118 headings in the approved catalog.

### Category routing

- Create one presenter, view contract, UI view, and Dagger component for each category route under `domino-demo/samples/samples-frontend`, `domino-demo/samples/samples-ui`, and `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components`.
- Use these category routes:

  ```text
  blueprints/application-foundations
  blueprints/dashboards
  blueprints/search-crud
  blueprints/master-detail
  blueprints/forms-configuration
  blueprints/workflow-approvals
  blueprints/reporting-analytics
  blueprints/scheduling
  blueprints/administration-security
  blueprints/content-collaboration
  blueprints/operations-monitoring
  blueprints/import-export
  blueprints/special-states
  ```

- Modify `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java` to add the three-level menu. Shell menu tokens remain literals to avoid a dependency from shell UI to samples UI.

### Verification

- Add a catalog manifest check under `domino-demo/samples/samples-ui/src/test/java/org/dominokit/demo/samples/blueprints/BlueprintCatalogManifestTest.java` only if the current test dependencies support it; otherwise use the repository’s existing Java source checks and Maven compilation.
- Verify the exact count of 118 sample classes, 13 category presenters, 13 category views, 13 components, and 13 third-level menu branches with `rg` checks.

---

### Task 1: Establish isolated baseline and shared blueprint primitives

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintFixtures.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintSampleSupport.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintSampleKind.java`
- Verify: `mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile`

**Interfaces:**
- `BlueprintFixtures.records(int count)`, `BlueprintFixtures.auditEvents()`, `BlueprintFixtures.tasks()`, `BlueprintFixtures.bookings()`, `BlueprintFixtures.metrics()`, and `BlueprintFixtures.files()` return deterministic local fixture lists.
- `BlueprintSampleSupport.toolbar(...)`, `filterBar(...)`, `recordRow(...)`, `emptyState(...)`, `errorState(...)`, `timelineItem(...)`, and `status(...)` return Domino UI elements that later samples can compose.
- `BlueprintSampleKind` identifies `TABLE_CRUD`, `FORM`, `DASHBOARD`, `MASTER_DETAIL`, `WORKFLOW`, `TIMELINE`, `SCHEDULER`, `LIBRARY`, `IMPORT`, `MONITOR`, and `STATE_GALLERY` compositions.

- [ ] **Step 1: Record the clean baseline in the new worktree.**

  Run:

  ```bash
  git status --short
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  ```

  Expected: no feature changes in the new worktree and `BUILD SUCCESS`.

- [ ] **Step 2: Add fixtures with no network dependencies.**

  Include enough records to demonstrate short and long lists, plus deterministic fixture values for workflow, reports, schedules, files, audit events, and special states.

- [ ] **Step 3: Add shared UI builders.**

  Keep the helpers focused on repeated structure and feedback; do not hide page-level sample composition inside them. All helpers must return existing Domino UI element types and use the same style utilities as current samples.

- [ ] **Step 4: Compile the shared layer.**

  ```bash
  mvn -pl demo-samples/demo-samples-ui -am -DskipTests compile
  ```

- [ ] **Step 5: Commit the primitive layer.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints
  git commit -m "feat: add blueprint sample primitives"
  ```

### Task 2: Add category route scaffolding and the three-level menu

**Files:**
- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java`
- Create: the 13 presenter/view/component triplets for the category routes listed in the file map.
- Verify: generated Brix/Dagger sources and menu token checks.

**Interfaces:**
- Every category presenter is a `ChildPresenter<ShellPresenter, CategoryView>` bound to `ShellPresenter.CONTENT_SLOT`.
- Every category UI view extends `SamplePageView<CategoryView.CategoryUiHandlers>` and exposes one `SampleShowcase` per catalog entry.
- Every third-level leaf uses a fragment token in the form `blueprints/<category>#<blueprint-slug>` while the category presenter route matches `blueprints/<category>`.

- [ ] **Step 1: Add 13 category route constants.**

  Keep constants in `samples-frontend` for presenter annotations and use the matching literal route paths in `ShellViewImpl`.

- [ ] **Step 2: Add the root and second-level menu branches.**

  Add a root `TreeItem` named `Blueprints`, then add these second-level labels: `Application foundations and navigation`, `Dashboards and overview screens`, `Search, list, and CRUD screens`, `Master-detail and record workspaces`, `Forms, configuration, and data-entry flows`, `Workflow, approvals, and task management`, `Reporting, analytics, and data exploration`, `Scheduling, calendars, and resource planning`, `Administration, identity, and security`, `Content, files, and collaboration`, `Operations, monitoring, and exception handling`, `Import, export, migration, and bulk operations`, and `Special states and constrained compositions`.

- [ ] **Step 3: Add all 118 third-level leaves from the catalog.**

  Use the exact blueprint heading as the menu label and a lowercase hyphenated slug as the fragment. Each leaf should prevent the default navigation and fire its category route plus fragment token.

- [ ] **Step 4: Create empty category pages with headers.**

  Each category page must compile before samples are added and must display the category title and the sentence `Blueprint samples for reusable enterprise screen compositions.`

- [ ] **Step 5: Compile route scaffolding.**

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  ```

- [ ] **Step 6: Verify the menu shape.**

  ```bash
  test "$(rg -c 'TreeItem.create\(Icons.view_dashboard\(\), \"Blueprints\"\)' domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java)" = 1
  test "$(rg -c 'makeSubMenu\(' domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java)" -ge 118
  ```

- [ ] **Step 7: Commit the route/menu scaffold.**

  ```bash
  git add domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add three-level blueprints navigation"
  ```

### Task 3: Implement categories 1–4

**Categories:** Application foundations and navigation (8), Dashboards and overview screens (8), Search/list/CRUD screens (14), and Master-detail and record workspaces (8).

**Files:**
- Create 38 named samples under `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/foundations`, `dashboards`, `searchcrud`, and `masterdetail`.
- Modify the four category UI views to add the exact sample classes in catalog order.
- Verify: category compilation and sample-count check.

**Interfaces:**
- Each sample has `public static <Name>Sample create()` and returns a concrete `IsElement<?>` root.
- CRUD samples use the shared record fixture and expose their specified editing location: dialog, top form, side panel, inline row, card grid, or bulk toolbar.
- Dashboard, search, and master-detail samples reuse support builders but retain distinct page composition and interaction copy.

- [ ] **Step 1: Create one named sample class per catalog heading in the four categories.**

  Derive the class name mechanically from the heading, remove punctuation, capitalize words, and append `Sample`; preserve a short domain-neutral title inside the sample.

- [ ] **Step 2: Implement the eight foundation samples.**

  Cover persistent navigation, secondary navigation, resizable pane, breadcrumb/back stack, command palette, multi-workspace, split navigation, and focused task shell.

- [ ] **Step 3: Implement the eight dashboard samples.**

  Include responsive KPI cards, command center, role home, drill-down, portfolio, productivity, saved views, and commentary/annotation interactions.

- [ ] **Step 4: Implement the fourteen list/search/CRUD samples.**

  Include all four requested CRUD variants, advanced search, facets, bulk actions, saved filters, read-only registry, comparison, row expansion, and the remaining catalog entries in section 3.

- [ ] **Step 5: Implement the eight master-detail samples.**

  Include record detail, persistent list, related entities, activity timeline, side inspector, comparison, preview/edit mode, and hierarchy explorer.

- [ ] **Step 6: Add each sample to its category page with its catalog description.**

  Use `SampleShowcase.create(title, description, Sample.class, Sample::create)` so source display and sample framing match existing pages.

- [ ] **Step 7: Compile and verify counts.**

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  test "$(rg -l 'class .*Sample' demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/foundations demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/dashboards demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/searchcrud demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail | wc -l)" -eq 38
  ```

- [ ] **Step 8: Commit categories 1–4.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add foundation dashboard and record blueprints"
  ```

### Task 4: Implement categories 5–8

**Categories:** Forms/configuration (10), Workflow/approvals (10), Reporting/analytics (8), and Scheduling (8).

**Files:**
- Create 36 named samples under `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/forms`, `workflow`, `reporting`, and `scheduling`.
- Modify the four category UI views to add all entries in catalog order.
- Verify: category compilation and sample-count check.

**Interfaces:**
- Form samples demonstrate validation, repeatable fields, conditional sections, drafts, preview, and wizard progression.
- Workflow samples demonstrate decisions, assignments, queues, boards, timelines, exceptions, SLAs, and checklists.
- Reporting samples demonstrate parameters, builders, pivots, time series, maps, metric governance, schedules, and data quality.
- Scheduling samples demonstrate calendars, resource lanes, booking, shifts, capacity, recurrence, and dependencies.

- [ ] **Step 1: Create and implement the ten form/configuration samples.**
- [ ] **Step 2: Create and implement the ten workflow/approval samples.**
- [ ] **Step 3: Create and implement the eight reporting/analytics samples.**
- [ ] **Step 4: Create and implement the eight scheduling samples.**
- [ ] **Step 5: Add all 36 samples to their category views using `SampleShowcase.create(...)`.**
- [ ] **Step 6: Compile and run the exact 36-class count check.**

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  test "$(rg -l 'class .*Sample' demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/forms demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/workflow demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/reporting demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/scheduling | wc -l)" -eq 36
  ```

- [ ] **Step 7: Commit categories 5–8.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add form workflow reporting and scheduling blueprints"
  ```

### Task 5: Implement categories 9–13

**Categories:** Administration/security (10), Content/collaboration (8), Operations/monitoring (8), Import/export/bulk (8), and Special states (10).

**Files:**
- Create 44 named samples under `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/administration`, `content`, `operations`, `importexport`, and `states`.
- Modify the five category UI views to add all entries in catalog order.
- Verify: category compilation and sample-count check.

**Interfaces:**
- Administration samples cover users, roles, policies, tenants, audits, credentials, flags, settings, response, and environment comparison.
- Content samples cover libraries, uploads, editors, versions, messages, broadcasts, comments, and knowledge bases.
- Operations samples cover health, incidents, jobs, integrations, alerts, logs, reconciliation, and inspections.
- Import/export samples cover mapping, correction, exports, bulk review, migration, cleanup, batch progress, and exchange status.
- State samples visibly demonstrate empty, loading, error, read-only, dirty, conflict, responsive, print, offline, and first-run states.

- [ ] **Step 1: Create and implement the ten administration/security samples.**
- [ ] **Step 2: Create and implement the eight content/collaboration samples.**
- [ ] **Step 3: Create and implement the eight operations/monitoring samples.**
- [ ] **Step 4: Create and implement the eight import/export/bulk samples.**
- [ ] **Step 5: Create and implement the ten special-state samples.**
- [ ] **Step 6: Add all 44 samples to their category views using `SampleShowcase.create(...)`.**
- [ ] **Step 7: Compile and run the exact 44-class count check.**

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  test "$(rg -l 'class .*Sample' demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/administration demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/content demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/operations demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/importexport demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/states | wc -l)" -eq 44
  ```

- [ ] **Step 8: Commit categories 9–13.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add administration content operations and state blueprints"
  ```

### Task 6: Wire fragments, category-page selection, and source links

**Files:**
- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java`
- Modify: all 13 category UI view implementations.
- Create: `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/blueprints/BlueprintFragmentSelection.java` if fragment parsing is not already available in the current history API.
- Verify: menu/category/sample mapping script and manual navigation.

**Interfaces:**
- `BlueprintFragmentSelection.read()` returns the selected sample slug from the current history fragment or an empty value.
- Category views render all samples in catalog order and scroll/focus the selected sample when its fragment is present; a missing fragment defaults to the first sample.

- [ ] **Step 1: Add stable DOM ids to each `SampleShowcase`.**

  Derive ids as `blueprint-<category-slug>-<blueprint-slug>` and keep the slug identical to the third-level menu fragment.

- [ ] **Step 2: Add fragment parsing and selection behavior.**

  Read the current `HistoryToken` fragment through the existing Domino history API, find the matching showcase id, and call the supported DOM scroll/focus method after attachment.

- [ ] **Step 3: Verify all third-level leaves map to an existing sample id.**

  Use a shell check that extracts menu fragments and compares them with sample ids/source names.

- [ ] **Step 4: Compile and manually test representative leaves.**

  Check one leaf in each category, direct URL loading, browser back/forward, and a category route without a fragment.

- [ ] **Step 5: Commit deep-link integration.**

  ```bash
  git add domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: deep-link blueprint menu leaves"
  ```

### Task 7: Full verification and handoff

**Files:**
- Verify all blueprint source, route, view, component, and menu files.
- Modify only focused defects found during verification.

- [ ] **Step 1: Verify the catalog count.**

  ```bash
  test "$(rg -c '^#### [0-9]+\.[0-9]+ ' docs/superpowers/specs/2026-09-05-enterprise-screen-blueprints-design.md)" -eq 118
  test "$(rg -l 'class .*Sample' demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints | wc -l)" -eq 118
  ```

- [ ] **Step 2: Verify all 13 category routes compile and are represented.**

  ```bash
  test "$(rg -l '@BrixRoute' domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints | wc -l)" -eq 13
  test "$(rg -l '@UiView' domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints | wc -l)" -eq 13
  test "$(rg -l '@BrixComponent' domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/*Blueprint*Component.java | wc -l)" -eq 13
  ```

- [ ] **Step 3: Build the complete demo reactor.**

  ```bash
  mvn -pl domino-demo -am -DskipTests package
  ```

  Expected: `BUILD SUCCESS` with generated Brix/Dagger sources for every category.

- [ ] **Step 4: Run formatting and whitespace checks.**

  ```bash
  git diff --check
  ```

- [ ] **Step 5: Review the final worktree diff.**

  Confirm that only the isolated feature branch contains blueprint implementation changes and that the original checkout’s UnitValue work remains untouched.

- [ ] **Step 6: Commit final corrections and report the branch/worktree path.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java
  git commit -m "feat: implement full blueprints catalog"
  ```
