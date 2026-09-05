# Blueprints Showcase Category Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Add a `Blueprints` showcase category containing reusable enterprise screen-composition samples, beginning with a representative first wave from the approved catalog.

**Architecture:** Follow the existing Brix pattern of one presenter, view contract, Dagger component, and UI view implementation per navigable showcase route. Keep blueprint screen implementations in `demo-samples-ui` as self-contained Domino UI elements backed by local in-memory fixtures; keep route/menu wiring in the existing shell and samples modules. Reuse `SamplePageView` and `SampleShowcase` so each blueprint is displayed consistently with current samples.

**Tech Stack:** Java, GWT, Domino UI, Domino Brix, Dagger, Maven, existing `demo-samples-ui`, `samples-frontend`, `samples-ui`, and shell modules.

**Spec:** `docs/superpowers/specs/2026-09-05-enterprise-screen-blueprints-design.md`

## Global Constraints

- The category is named exactly `Blueprints`.
- Blueprint samples are domain-neutral compositions; use believable local fixtures rather than introducing a backend API for this phase.
- Every sample must demonstrate its layout and primary interaction pattern, not just a static wireframe.
- Future samples should expose meaningful loading, empty, validation, permission, or error states where those states are part of the blueprint.
- Preserve existing unrelated worktree changes.
- Use existing Brix presenter/view/component conventions and `SamplePageView`/`SampleShowcase` infrastructure.
- The first implementation wave covers the approved representative patterns, while the catalog remains the source of truth for later expansion.

---

## First-wave file map

Each route below creates the listed concrete files. Annotation processing creates the generated Brix view/presenter modules and Dagger implementations; those generated files are build output and must not be hand-edited.

| Route | Shared sample | Presenter | View contract | Component | UI view |
|---|---|---|---|---|---|
| `blueprints/crud-short-dialog` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/ShortListDialogCrudSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/crud/ShortListDialogCrudPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/crud/shortdialog/ShortListDialogCrudView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/ShortListDialogCrudComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/crud/shortdialog/ShortListDialogCrudViewImpl.java` |
| `blueprints/crud-short-top-form` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/ShortListTopFormCrudSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/crud/ShortListTopFormCrudPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/crud/shortform/ShortListTopFormCrudView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/ShortListTopFormCrudComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/crud/shortform/ShortListTopFormCrudViewImpl.java` |
| `blueprints/crud-long-dialog` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/LongListDialogCrudSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/crud/LongListDialogCrudPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/crud/longdialog/LongListDialogCrudView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/LongListDialogCrudComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/crud/longdialog/LongListDialogCrudViewImpl.java` |
| `blueprints/crud-long-side-panel` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/LongListSidePanelCrudSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/crud/LongListSidePanelCrudPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/crud/longpanel/LongListSidePanelCrudView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/LongListSidePanelCrudComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/crud/longpanel/LongListSidePanelCrudViewImpl.java` |
| `blueprints/search-directory` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search/SearchDirectorySample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/search/SearchDirectoryPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/search/directory/SearchDirectoryView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/SearchDirectoryComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/search/directory/SearchDirectoryViewImpl.java` |
| `blueprints/record-workspace` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/records/RecordWorkspaceSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/records/RecordWorkspacePresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/records/workspace/RecordWorkspaceView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/RecordWorkspaceComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/records/workspace/RecordWorkspaceViewImpl.java` |
| `blueprints/draft-form` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/forms/DraftFormSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/forms/DraftFormPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/forms/draft/DraftFormView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/DraftFormComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/forms/draft/DraftFormViewImpl.java` |
| `blueprints/approval-request` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/workflow/ApprovalRequestSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/workflow/ApprovalRequestPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/workflow/approval/ApprovalRequestView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/ApprovalRequestComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/workflow/approval/ApprovalRequestViewImpl.java` |
| `blueprints/team-queue` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/workflow/TeamQueueSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/workflow/TeamQueuePresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/workflow/queue/TeamQueueView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/TeamQueueComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/workflow/queue/TeamQueueViewImpl.java` |
| `blueprints/kpi-dashboard` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/dashboard/KpiDashboardSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/dashboard/KpiDashboardPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/dashboard/kpi/KpiDashboardView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/KpiDashboardComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/dashboard/kpi/KpiDashboardViewImpl.java` |
| `blueprints/resource-scheduler` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/scheduling/ResourceSchedulerSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/scheduling/ResourceSchedulerPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/scheduling/resource/ResourceSchedulerView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/ResourceSchedulerComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/scheduling/resource/ResourceSchedulerViewImpl.java` |
| `blueprints/document-library` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/content/DocumentLibrarySample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/content/DocumentLibraryPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/content/library/DocumentLibraryView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/DocumentLibraryComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/content/library/DocumentLibraryViewImpl.java` |
| `blueprints/import-wizard` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/imports/ImportWizardSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/imports/ImportWizardPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/imports/wizard/ImportWizardView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/ImportWizardComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/imports/wizard/ImportWizardViewImpl.java` |
| `blueprints/audit-log` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/governance/AuditLogSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/governance/AuditLogPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/governance/audit/AuditLogView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/AuditLogComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/governance/audit/AuditLogViewImpl.java` |
| `blueprints/incident-workspace` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/operations/IncidentWorkspaceSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/operations/IncidentWorkspacePresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/operations/incident/IncidentWorkspaceView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/IncidentWorkspaceComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/operations/incident/IncidentWorkspaceViewImpl.java` |
| `blueprints/special-states` | `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/states/SpecialStatesSample.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/states/SpecialStatesPresenter.java` | `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints/states/special/SpecialStatesView.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components/SpecialStatesComponent.java` | `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints/states/special/SpecialStatesViewImpl.java` |

---

### Task 1: Establish blueprint fixture and UI helper boundaries

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintFixtures.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintRecord.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/BlueprintUi.java`
- Test/verify: `demo-samples/demo-samples-ui` Maven compile

**Interfaces:**
- Produces `BlueprintFixtures.shortRecords()`, `BlueprintFixtures.longRecords()`, and `BlueprintFixtures.auditEvents()` returning deterministic in-memory data for later samples.
- Produces `BlueprintRecord` with stable id, name, category, status, owner, date, amount, and description values sufficient for list/detail/editor samples.
- Produces `BlueprintUi.statusBadge(...)`, `BlueprintUi.toolbarButton(...)`, and `BlueprintUi.sectionTitle(...)` helpers for repeated visual vocabulary without creating a second page framework.

- [ ] **Step 1: Define the smallest shared record model and fixture data.**

  Use immutable-looking construction with setters or builders only where existing Domino UI APIs require mutable records. Include at least ten short records, enough long records to exercise pagination/scrolling, and audit events with actor, action, target, timestamp, and severity.

- [ ] **Step 2: Add shared display helpers only for repeated blueprint concerns.**

  Keep helpers limited to status badges, compact section headings, and toolbar buttons. Do not move page-specific layout or interaction logic into the helper class.

- [ ] **Step 3: Compile the shared module.**

  Run:

  ```bash
  mvn -pl demo-samples/demo-samples-ui -am -DskipTests compile
  ```

  Expected: BUILD SUCCESS with no Java or GWT source errors.

- [ ] **Step 4: Commit the fixture boundary.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints
  git commit -m "feat: add blueprint sample fixtures"
  ```

### Task 2: Add the Blueprints navigation category and route registration pattern

**Files:**
- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java`
- Create: `domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/BlueprintsRouteNames.java`
- Verify generated route/component sources under Maven build output; do not hand-edit generated `Brix*Module_` or `Dagger*` files.

**Interfaces:**
- Produces route constants such as `BlueprintsRouteNames.SHORT_DIALOG = "blueprints/crud-short-dialog"` so menu labels and presenter annotations share one source.
- Adds an expandable root `Blueprints` tree item with child labels matching the implementation roadmap.

- [ ] **Step 1: Create route constants for the first wave.**

  Define constants for:

  ```java
  public static final String SHORT_DIALOG = "blueprints/crud-short-dialog";
  public static final String SHORT_TOP_FORM = "blueprints/crud-short-top-form";
  public static final String LONG_DIALOG = "blueprints/crud-long-dialog";
  public static final String LONG_SIDE_PANEL = "blueprints/crud-long-side-panel";
  public static final String SEARCH_DIRECTORY = "blueprints/search-directory";
  public static final String RECORD_WORKSPACE = "blueprints/record-workspace";
  public static final String DRAFT_FORM = "blueprints/draft-form";
  public static final String APPROVAL_REQUEST = "blueprints/approval-request";
  public static final String TEAM_QUEUE = "blueprints/team-queue";
  public static final String KPI_DASHBOARD = "blueprints/kpi-dashboard";
  public static final String RESOURCE_SCHEDULER = "blueprints/resource-scheduler";
  public static final String DOCUMENT_LIBRARY = "blueprints/document-library";
  public static final String IMPORT_WIZARD = "blueprints/import-wizard";
  public static final String AUDIT_LOG = "blueprints/audit-log";
  public static final String INCIDENT_WORKSPACE = "blueprints/incident-workspace";
  public static final String SPECIAL_STATES = "blueprints/special-states";
  ```

- [ ] **Step 2: Add the root menu item after the existing primary showcase categories.**

  Use the existing `TreeItem.create(...).apply(addToggleIcon())` and `makeSubMenu(...)` conventions. Add child labels that explain composition, for example `CRUD — short list / dialog editor`, rather than generic names such as `Sample 1`.

- [ ] **Step 3: Add `href` and click handling through the existing `makeSubMenu` path.**

  Confirm that each child uses the same route token for its anchor and `handlers().onMenuItemSelected(token)` callback.

- [ ] **Step 4: Verify the menu source and route constants before any samples exist.**

  Run:

  ```bash
  rg -n "Blueprints|blueprints/" domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/BlueprintsRouteNames.java
  ```

  Expected: one root category and sixteen child route tokens, with no edits to unrelated menu categories.

- [ ] **Step 5: Commit the navigation slice.**

  ```bash
  git add domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints/BlueprintsRouteNames.java
  git commit -m "feat: add blueprints showcase navigation"
  ```

### Task 3: Implement the four CRUD composition blueprints

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/ShortListDialogCrudSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/ShortListTopFormCrudSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/LongListDialogCrudSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/LongListSidePanelCrudSample.java`
- Create/modify: one presenter, view contract, UI view, and Dagger component per route under `domino-demo/samples/samples-frontend`, `domino-demo/samples/samples-ui`, and `domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components`
- Verify: `domino-demo/samples/samples-ui` Maven compile and route grep

**Interfaces:**
- Each sample exposes `public static <SampleName> create()` and returns a Domino UI root element.
- Each route presenter extends `ChildPresenter<ShellPresenter, ...View>`, uses `@BrixRoute`, and binds to `ShellPresenter.CONTENT_SLOT`.
- Each UI view extends `SamplePageView<...UiHandlers>`, adds one `SampleShowcase`, and calls `initPage()`.

- [ ] **Step 1: Implement the short-list dialog editor.**

  Render a compact table of fixture records with add/edit/delete controls. Open a dialog for add and edit, validate the name and required category, update the local list on save, and show an explicit confirmation before delete.

- [ ] **Step 2: Implement the short-list top-section form.**

  Place the record form above the table. Selecting a row loads it into the form; `New` clears the form; save creates or updates; cancel returns to a clean form state. Keep the list visible while editing.

- [ ] **Step 3: Implement the long-list dialog editor.**

  Use enough fixture records to make paging or a scroll region meaningful. Add a filter/search toolbar, row selection, add/edit dialog, and a disabled/loading state on the save action while simulating a short local operation.

- [ ] **Step 4: Implement the long-list side-panel editor.**

  Keep the table visible while opening a right-side editor or drawer. Selecting another row must replace the editor content without navigating away; unsaved changes must require an explicit discard or save choice.

- [ ] **Step 5: Wire the four presenter/view/component triplets.**

  Follow the existing `BasicDataTablePresenter`, `BasicDataTableView`, `BasicDataTableViewImpl`, and `BasicDataTableComponent` shapes. Let annotation processing generate the Brix and Dagger modules.

- [ ] **Step 6: Compile and verify the CRUD routes.**

  Run:

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  rg -n "crud-short-dialog|crud-short-top-form|crud-long-dialog|crud-long-side-panel" domino-demo/samples domino-demo/shell
  ```

  Expected: BUILD SUCCESS and each route appears in exactly one presenter annotation and one menu child.

- [ ] **Step 7: Commit the CRUD blueprint group.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add CRUD blueprint samples"
  ```

### Task 4: Implement search, master-detail, and draft form blueprints

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search/SearchDirectorySample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/records/RecordWorkspaceSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/forms/DraftFormSample.java`
- Create/modify: corresponding presenter, view contract, UI view, and Dagger component files for `SEARCH_DIRECTORY`, `RECORD_WORKSPACE`, and `DRAFT_FORM`
- Verify: `domino-demo/samples/samples-ui` Maven compile

**Interfaces:**
- Search sample demonstrates query input, filters, result count, and empty-result recovery.
- Record workspace exposes a selected record, summary header, related sections, and activity timeline.
- Draft form exposes explicit draft status, autosave simulation, validation, and discard/recover actions.

- [ ] **Step 1: Build the search-first directory.**

  Start with an empty state, transition to results after a query, provide facet chips and a clear-filters action, and open a selected record in the existing detail convention.

- [ ] **Step 2: Build the master-detail record workspace.**

  Keep a searchable record list visible beside a detail pane. Include summary, related records, activity timeline, and next/previous record controls while preserving list selection.

- [ ] **Step 3: Build the draft/autosave form.**

  Use grouped fields with validation, a visible `Draft saved`/`Saving`/`Unsaved changes` indicator, a recover-draft action, and navigation protection before discard.

- [ ] **Step 4: Wire and compile the three routes.**

  Run:

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  rg -n "search-directory|record-workspace|draft-form" domino-demo/samples domino-demo/shell
  ```

- [ ] **Step 5: Commit the search/detail/form group.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/records demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/forms domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add search detail and draft blueprints"
  ```

### Task 5: Implement workflow, approval, queue, and dashboard blueprints

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/workflow/ApprovalRequestSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/workflow/TeamQueueSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/dashboard/KpiDashboardSample.java`
- Create/modify: corresponding presenter, view contract, UI view, and Dagger component files for `APPROVAL_REQUEST`, `TEAM_QUEUE`, and `KPI_DASHBOARD`
- Verify: `domino-demo/samples/samples-ui` Maven compile

**Interfaces:**
- Approval request demonstrates review evidence, comments, history, and approve/reject/request-changes transitions.
- Team queue demonstrates assignment, priority/status filters, row selection, and bulk action toolbar.
- KPI dashboard demonstrates global filters, metric cards, chart/table drill-down, and a loading or no-data state.

- [ ] **Step 1: Implement the approval request.**

  Use a request summary with status badge, submitted values, evidence list, decision footer, comments, and history. Disable conflicting decisions while a local decision is being applied and show the resulting status.

- [ ] **Step 2: Implement the team queue.**

  Render queue rows with owner, priority, age, SLA indicator, and status. Add claim/reassign actions, selection-aware bulk toolbar, and a detail panel for the selected work item.

- [ ] **Step 3: Implement the KPI dashboard.**

  Render a responsive card grid with date/team filters, at least two metric cards, a trend visualization, and a supporting table. Clicking a metric or chart point must apply a visible drill-down filter.

- [ ] **Step 4: Wire and compile the workflow/dashboard routes.**

  Run:

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  rg -n "approval-request|team-queue|kpi-dashboard" domino-demo/samples domino-demo/shell
  ```

- [ ] **Step 5: Commit the workflow/dashboard group.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/workflow demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/dashboard domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add workflow and dashboard blueprints"
  ```

### Task 6: Implement scheduling, content, and import blueprints

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/scheduling/ResourceSchedulerSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/content/DocumentLibrarySample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/imports/ImportWizardSample.java`
- Create/modify: corresponding presenter, view contract, UI view, and Dagger component files for `RESOURCE_SCHEDULER`, `DOCUMENT_LIBRARY`, and `IMPORT_WIZARD`
- Verify: `domino-demo/samples/samples-ui` Maven compile

**Interfaces:**
- Scheduler demonstrates time/resource axes, booking blocks, conflict indication, and create/move/resize interactions.
- Document library demonstrates folder navigation, file list, upload affordance, preview panel, and file actions.
- Import wizard demonstrates upload, column mapping, validation preview, correction, and final commit summary.

- [ ] **Step 1: Implement the resource scheduler.**

  Use deterministic resources and time slots. Render bookings in a calendar/timeline composition and support selecting an open slot, moving a booking, and showing an overlap warning.

- [ ] **Step 2: Implement the document library.**

  Render a folder tree or breadcrumb, file list/grid, search, upload state, and preview/detail panel. Include empty-folder behavior and disabled actions for a read-only file.

- [ ] **Step 3: Implement the import wizard.**

  Use a four-stage visual flow: select file, map columns, validate rows, commit. Include invalid-row messaging and a correction action before allowing the final commit.

- [ ] **Step 4: Wire and compile the routes.**

  Run:

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  rg -n "resource-scheduler|document-library|import-wizard" domino-demo/samples domino-demo/shell
  ```

- [ ] **Step 5: Commit the scheduling/content/import group.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/scheduling demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/content demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/imports domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add scheduling content and import blueprints"
  ```

### Task 7: Implement audit, incident, and special-state blueprints

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/governance/AuditLogSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/operations/IncidentWorkspaceSample.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/states/SpecialStatesSample.java`
- Create/modify: corresponding presenter, view contract, UI view, and Dagger component files for `AUDIT_LOG`, `INCIDENT_WORKSPACE`, and `SPECIAL_STATES`
- Verify: `domino-demo/samples/samples-ui` Maven compile

**Interfaces:**
- Audit log demonstrates filterable event table, expandable payload/detail, before-after values, and export affordance.
- Incident workspace demonstrates severity/status, responders, timeline, checklist, and resolve/postmortem transition.
- Special states demonstrates loading, empty, error, read-only, and unsaved/conflict variants in a single documented page.

- [ ] **Step 1: Implement the audit log explorer.**

  Provide actor/action/target/date filters, a dense event table, expandable event detail, and a no-results state with clear-filter recovery.

- [ ] **Step 2: Implement the incident workspace.**

  Show incident summary, severity, owner/responders, timeline, action checklist, communication log, and resolve control with a confirmation step.

- [ ] **Step 3: Implement the special-state gallery.**

  Use separate labeled cards or sections for initial loading, empty, partial error, read-only, unsaved changes, and conflict resolution. Each state must show the user action that recovers from it.

- [ ] **Step 4: Wire and compile the routes.**

  Run:

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  rg -n "audit-log|incident-workspace|special-states" domino-demo/samples domino-demo/shell
  ```

- [ ] **Step 5: Commit the operations/state group.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/governance demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/operations demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/states domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: add audit incident and state blueprints"
  ```

### Task 8: Integrate the category and perform full verification

**Files:**
- Modify: `domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java` only if labels or ordering need final adjustment
- Modify: blueprint UI view implementations only for integration defects found during verification
- Test/verify: root Maven build and route/catalog consistency checks

**Interfaces:**
- All sixteen child routes are reachable from the `Blueprints` root menu item.
- Every route has exactly one presenter, view contract, UI view, and Dagger component.
- Every menu label describes the composition represented by its sample.

- [ ] **Step 1: Verify every route has a matching presenter annotation.**

  Run:

  ```bash
  for route in crud-short-dialog crud-short-top-form crud-long-dialog crud-long-side-panel search-directory record-workspace draft-form approval-request team-queue kpi-dashboard resource-scheduler document-library import-wizard audit-log incident-workspace special-states; do
    rg -l "blueprints/$route" domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints >/dev/null || exit 1
  done
  echo "all blueprint routes have presenters"
  ```

  Expected: the command prints `all blueprint routes have presenters`.

- [ ] **Step 2: Build the complete demo.**

  Run:

  ```bash
  mvn -pl domino-demo -am -DskipTests package
  ```

  Expected: BUILD SUCCESS, generated Brix/Dagger sources complete, and no failures from unrelated existing modules.

- [ ] **Step 3: Check the final source diff and preserve unrelated work.**

  Run:

  ```bash
  git status --short
  git diff --check
  git diff --stat HEAD~16..HEAD
  ```

  Confirm that only blueprint implementation commits and the intended shell/menu changes are included in the feature history; do not stage or revert the pre-existing local edits listed before implementation.

- [ ] **Step 4: Review the rendered application manually.**

  Open each menu item and check that the sample visibly demonstrates its promised composition, the primary mutation or navigation interaction works, and narrow layouts do not hide the main action. Record any UI-only corrections as a focused follow-up commit.

- [ ] **Step 5: Commit final integration corrections.**

  ```bash
  git add domino-demo/shell/shell-ui/src/main/java/org/dominokit/demo/shell/ui/views/shell/ShellViewImpl.java demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/presenters/blueprints domino-demo/samples/samples-frontend/src/main/java/org/dominokit/demo/samples/views/blueprints domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/components domino-demo/samples/samples-ui/src/main/java/org/dominokit/demo/samples/ui/views/blueprints
  git commit -m "feat: integrate blueprints showcase category"
  ```
