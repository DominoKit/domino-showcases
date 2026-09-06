# Master-detail Blueprint Depth Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Replace the eight Master-detail and record-workspace placeholders with interactive local compositions covering persistent selection, tabs, related records, activity, inspectors, comparison, edit modes, and hierarchy navigation.

**Architecture:** Reuse the existing CRUD record model, store, list, and editor for the shared record workspace foundation. Add a small pure-Java workspace state object for selected record, active tab, preview/edit mode, inspector pinning, comparison selection, hierarchy expansion, and activity filtering. A shared `MasterDetailBlueprintView` will expose eight explicit factories, while each catalog sample remains an independent entry class.

**Tech Stack:** Java 17, GWT/J2CL, Domino UI, existing blueprint CRUD primitives, Maven, JUnit 4.

**Spec:** `docs/superpowers/specs/2026-09-05-enterprise-screen-blueprints-design.md`

## Global Constraints

- Use deterministic local fixtures only; no backend API or network dependency is introduced.
- Preserve the eight existing blueprint names, descriptions, menu routes, and category ordering.
- Keep each blueprint as an independent `*Sample` class while sharing the Master-detail implementation primitives.
- Every composition must visibly expose its defining interaction: navigation, tabs, related entities, timeline, inspector, preview/edit, comparison, or hierarchy expansion.
- Use existing Domino UI components and the CRUD primitives already merged into `main`.
- Preserve unrelated UnitValue changes in the main checkout; all implementation changes stay in this worktree.

---

## File map

### Master-detail state and fixtures

- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailWorkspaceState.java` — pure state transitions for selected records, tabs, edit mode, comparison, inspector, hierarchy, and activity filtering.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailFixtures.java` — deterministic related entities, activity events, and hierarchy nodes.
- Create: `demo-samples/demo-samples-ui/src/test/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailWorkspaceStateTest.java` — state transition tests.

### Shared Master-detail UI

- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailBlueprintView.java` — eight public factories and local UI wiring.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailDetailPane.java` — record header, tabbed detail, related sections, activity timeline, inspector, and compare rendering.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailHierarchyPane.java` — expandable hierarchy tree and selected-node details.

### Catalog sample replacements

- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/MasterDetailWithPersistentRecordListSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/MasterDetailRecordPageSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/RecordOverviewWithRelatedEntitiesSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/RecordPageWithActivityTimelineSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/RecordPageWithSideInspectorSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/RecordSplitViewWithPreviewAndEditModesSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/MultiRecordComparisonWorkspaceSample.java`
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces/HierarchicalEntityExplorerSample.java`

---

### Task 1: Add the tested Master-detail state model

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailWorkspaceState.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailFixtures.java`
- Create: `demo-samples/demo-samples-ui/src/test/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailWorkspaceStateTest.java`

**Interfaces:**
- `MasterDetailWorkspaceState.create(CrudRecordStore store)` creates isolated UI state around an existing record store.
- `selectedRecord()` returns the selected `CrudRecord`, if any.
- `selectNext()` and `selectPrevious()` move through the current record order and clamp at the ends.
- `setActiveTab(String tab)` and `activeTab()` manage `Summary`, `Related`, and `Activity` detail tabs.
- `setEditMode(boolean)` and `isEditMode()` manage preview/edit state.
- `setInspectorPinned(boolean)` and `isInspectorPinned()` manage the side inspector.
- `toggleCompared(String id)` and `comparedIds()` manage up to three comparison records.
- `toggleExpanded(String nodeId)` and `isExpanded(String nodeId)` manage hierarchy nodes.
- `activityMatches(String query)` returns deterministic activity fixtures filtered case-insensitively.

- [ ] **Step 1: Add failing state tests.**

  Cover selecting the first record, next/previous clamping, tab changes, edit-mode transitions, inspector pinning, comparison maximum of three records, hierarchy expansion toggles, and activity filtering.

- [ ] **Step 2: Run the focused test and verify the expected failure.**

  Run: `mvn -pl demo-samples/demo-samples-ui -Dtest=MasterDetailWorkspaceStateTest test`

  Expected: test compilation failure because the state model does not exist yet.

- [ ] **Step 3: Add deterministic fixtures.**

  Define related entities, six activity events, and a three-level hierarchy using plain Java value objects with stable ids and labels.

- [ ] **Step 4: Implement the minimal state transitions.**

  Reuse `CrudRecordStore` for record selection and keep all UI state local to the new state object.

- [ ] **Step 5: Run the focused state test and module tests.**

  Run: `mvn -pl demo-samples/demo-samples-ui -Dtest=MasterDetailWorkspaceStateTest test` and then `mvn -pl demo-samples/demo-samples-ui -am test`.

- [ ] **Step 6: Commit the state layer.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail demo-samples/demo-samples-ui/src/test/java/org/dominokit/showcases/samples/blueprints/masterdetail
  git commit -m "feat: add tested master-detail workspace state"
  ```

### Task 2: Build shared detail and hierarchy panes

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailDetailPane.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailHierarchyPane.java`

**Interfaces:**
- `MasterDetailDetailPane.create(CrudRecord record, MasterDetailWorkspaceState state, Runnable refresh, Consumer<CrudRecord> save)` renders the selected record and its active detail mode.
- `MasterDetailHierarchyPane.create(MasterDetailWorkspaceState state, Runnable refresh)` renders expandable nodes and the selected node details.

- [ ] **Step 1: Establish the compile gate for both pane factories.**

  These classes are GWT-bound UI elements and are not instantiated in JVM unit tests. Add their public factory signatures first, then use `mvn -pl demo-samples/demo-samples-ui -am -DskipTests compile` as the immediate red/green gate.

- [ ] **Step 2: Implement the common record header and Summary tab.**

  Show record name, owner, status, description, next/previous controls, and an Edit/Preview toggle.

- [ ] **Step 3: Implement Related and Activity tabs.**

  Related renders linked entity cards and an Add related action. Activity renders the six local events, a text filter, and a post-note control that reports feedback without a backend.

- [ ] **Step 4: Implement the inspector and comparison regions.**

  Inspector exposes pin/unpin, metadata, and contextual actions. Comparison renders two or three selected records in aligned columns and provides add/remove comparison controls.

- [ ] **Step 5: Implement the hierarchy pane.**

  Render expand/collapse buttons for each node, selection, add-child feedback, and the selected node detail card.

- [ ] **Step 6: Compile the shared panes.**

  Run: `mvn -pl demo-samples/demo-samples-ui -am -DskipTests compile`

- [ ] **Step 7: Commit the shared panes.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail
  git commit -m "feat: add master-detail detail panes"
  ```

### Task 3: Implement the eight concrete compositions

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail/MasterDetailBlueprintView.java`
- Modify: the eight catalog sample files listed in the file map.

**Interfaces:**
- `MasterDetailBlueprintView.persistentRecordList()` returns a list-plus-detail workspace with next/previous selection.
- `MasterDetailBlueprintView.recordPage()` returns a record page with summary, related, and activity tabs.
- `MasterDetailBlueprintView.relatedEntities()` returns a record overview with related cards and parent context.
- `MasterDetailBlueprintView.activityTimeline()` returns a record-and-timeline composition with filtering and note posting.
- `MasterDetailBlueprintView.sideInspector()` returns a record page with a toggleable inspector rail.
- `MasterDetailBlueprintView.previewAndEdit()` returns a split view with explicit preview/edit/save/cancel transitions.
- `MasterDetailBlueprintView.compareRecords()` returns an aligned two/three-record comparison workspace.
- `MasterDetailBlueprintView.hierarchyExplorer()` returns the expandable hierarchy composition.

- [ ] **Step 1: Add the source mapping contract check before replacing entries.**

  Verify that the eight sample classes still point to `BlueprintSampleSupport.create(title, description, BlueprintSampleKind.DETAIL, regions)` before implementation, so the replacement is observable.

- [ ] **Step 2: Implement the persistent record-list composition.**

  Render the reusable record list beside the detail pane; selecting a row updates the detail, and next/previous controls move through records.

- [ ] **Step 3: Implement the record-page composition.**

  Render a full-width record header with Summary, Related, and Activity tabs plus edit mode.

- [ ] **Step 4: Implement related entities and activity timeline compositions.**

  Configure the shared pane so each sample emphasizes its respective section and interaction.

- [ ] **Step 5: Implement side inspector and preview/edit compositions.**

  Configure the split layout, pin/unpin behavior, and explicit save/cancel transitions.

- [ ] **Step 6: Implement comparison and hierarchy compositions.**

  Configure aligned comparison columns and the expandable three-level hierarchy layout.

- [ ] **Step 7: Replace all eight placeholder sample bodies.**

  Preserve each existing public `create()` method and catalog description, returning the matching `MasterDetailBlueprintView` factory.

- [ ] **Step 8: Run mapping and affected compile checks.**

  ```bash
  rg -n "MasterDetailBlueprintView\.(persistentRecordList|recordPage|relatedEntities|activityTimeline|sideInspector|previewAndEdit|compareRecords|hierarchyExplorer)" demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  ```

- [ ] **Step 9: Commit the eight compositions.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/masterdetail demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/master_detail_and_record_workspaces
  git commit -m "feat: implement master-detail blueprint compositions"
  ```

### Task 4: Verify integration and handoff

**Files:**
- Verify: all files changed by Tasks 1–3.
- Modify: none unless verification identifies a concrete defect.

- [ ] **Step 1: Run focused state tests.**

  ```bash
  mvn -pl demo-samples/demo-samples-ui -Dtest=MasterDetailWorkspaceStateTest test
  ```

- [ ] **Step 2: Run the affected reactor compile.**

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  ```

- [ ] **Step 3: Run the full repository tests.**

  ```bash
  mvn test -q
  ```

- [ ] **Step 4: Verify mapping, diff hygiene, and clean worktree.**

  ```bash
  git diff --check
  git status --short --branch
  ```

- [ ] **Step 5: After merge approval, remove this worktree and delete `feature/blueprints-master-detail-depth`.**
