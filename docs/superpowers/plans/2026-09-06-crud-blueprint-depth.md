# CRUD Blueprint Depth Implementation Plan

> **For agentic workers:** REQUIRED SUB-SKILL: Use superpowers:subagent-driven-development (recommended) or superpowers:executing-plans to implement this plan task-by-task. Steps use checkbox (`- [ ]`) syntax for tracking.

**Goal:** Replace the four Search, List, and CRUD blueprint placeholders with working, stateful local CRUD compositions that demonstrate their distinct editor placements and list sizes.

**Architecture:** Add a domain-neutral in-memory record store and deterministic fixtures in the shared blueprint package. Build focused reusable UI pieces for the record toolbar, list rows, editor fields, status feedback, pagination, and delete confirmation. Keep the four existing sample entry classes as separate catalog entries, but have each construct its own composition through a shared CRUD renderer configured for dialog, top-section, paginated-dialog, or persistent-side-panel editing.

**Tech Stack:** Java 17, GWT/J2CL, Domino UI, existing `BaseDominoElement` and `SampleShowcase` conventions, Maven.

**Spec:** `docs/superpowers/specs/2026-09-05-enterprise-screen-blueprints-design.md`

## Global Constraints

- Use deterministic in-memory data only; no backend API or network dependency is introduced.
- Preserve the four existing blueprint names, descriptions, menu routes, and category ordering.
- Keep each blueprint as an independent `*Sample` class while sharing the CRUD implementation primitives.
- Every editor placement must be visibly different and usable: dialog, top section, dialog with long-list pagination, and persistent side panel.
- CRUD actions must update the visible local list: search/filter, select, add, edit, delete, cancel, and save.
- Invalid empty names must remain visible as validation feedback and must not mutate the store.
- Preserve unrelated changes in the main checkout; all implementation changes stay in this worktree.

---

## File map

### Domain and state

- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecord.java` — mutable form-friendly record value with id, name, owner, status, and description.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordStore.java` — deterministic in-memory CRUD, filtering, selection, and pagination state.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordFixtures.java` — short and long fixture sets.
- Create: `demo-samples/demo-samples-ui/src/test/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordStoreTest.java` — pure Java tests for filtering, CRUD mutation, validation, and page boundaries.
- Modify: `demo-samples/demo-samples-ui/pom.xml` — add the test-scoped JUnit dependency needed by the pure Java store test if the existing Maven test classpath has no test framework.

### Reusable CRUD UI

- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudBlueprintView.java` — shared composition builder with four public factories: `shortListWithDialog()`, `shortListWithTopEditor()`, `longListWithDialog()`, and `longListWithSideEditor()`.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordList.java` — renders the visible records, row selection, edit/delete actions, and empty filtered state.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordEditor.java` — renders name, owner, status, and description fields with save/cancel callbacks and inline validation.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudListToolbar.java` — renders search, add, refresh, and long-list pagination controls.
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudFeedback.java` — renders operation status and confirmation feedback without hiding page-level composition.

### Catalog sample replacements

- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search_list_and_crud_screens/ShortListCrudWithDialogEditorSample.java` — use the short-list modal composition.
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search_list_and_crud_screens/ShortListCrudWithTopSectionEditorSample.java` — use the inline top-section editor composition.
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search_list_and_crud_screens/LongListCrudWithDialogEditorSample.java` — use the paginated long-list modal composition.
- Modify: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search_list_and_crud_screens/LongListCrudWithPersistentSidePanelEditorSample.java` — use the long-list persistent side-panel composition.

---

### Task 1: Add the tested CRUD domain model

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecord.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordStore.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordFixtures.java`
- Create: `demo-samples/demo-samples-ui/src/test/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordStoreTest.java`
- Modify: `demo-samples/demo-samples-ui/pom.xml` only if required for the test dependency

**Interfaces:**
- `CrudRecord.create(String id, String name, String owner, String status, String description)` creates a copyable form-friendly record.
- `CrudRecordStore.create(List<CrudRecord> initialRecords)` creates an isolated store.
- `CrudRecordStore.records()` returns the current records in display order.
- `CrudRecordStore.search(String query)` returns records whose name, owner, status, or description contains the case-insensitive query.
- `CrudRecordStore.add(CrudRecord draft)`, `update(CrudRecord draft)`, and `delete(String id)` mutate the store and return a boolean indicating whether the operation was accepted.
- `CrudRecordStore.page(String query, int page, int pageSize)` returns a bounded page object containing records, zero-based page index, page count, and total matches.
- `CrudRecordStore.selectedId()` and `select(String id)` manage the current row selection.

- [ ] **Step 1: Add a failing test for search and page boundaries.**

  Test that a case-insensitive search narrows the fixture set and that requesting a page beyond the last page returns an empty record list with the last valid page index.

- [ ] **Step 2: Run the focused test and verify the expected failure.**

  Run: `mvn -pl demo-samples/demo-samples-ui -Dtest=CrudRecordStoreTest test`

  Expected: test compilation or assertion failure because the store API does not exist yet.

- [ ] **Step 3: Add the minimal record, fixture, and store implementation.**

  Use stable ids such as `record-01` through `record-24`; keep the short fixture set at six records and the long fixture set at twenty-four records. Clamp page indexes rather than throwing for an out-of-range page.

- [ ] **Step 4: Add failing tests for CRUD validation and selection.**

  Cover add/update/delete, reject blank names without mutation, preserve record order on update, and clear selection when the selected record is deleted.

- [ ] **Step 5: Run the focused test and verify the new failures are meaningful.**

  Run: `mvn -pl demo-samples/demo-samples-ui -Dtest=CrudRecordStoreTest test`

- [ ] **Step 6: Implement the smallest changes needed to pass all store tests.**

- [ ] **Step 7: Run the focused test and the module test phase.**

  Run: `mvn -pl demo-samples/demo-samples-ui -Dtest=CrudRecordStoreTest test` and then `mvn -pl demo-samples/demo-samples-ui -am test`.

- [ ] **Step 8: Commit the domain layer.**

  ```bash
  git add demo-samples/demo-samples-ui/pom.xml demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud demo-samples/demo-samples-ui/src/test/java/org/dominokit/showcases/samples/blueprints/crud
  git commit -m "feat: add tested CRUD blueprint state"
  ```

### Task 2: Build reusable CRUD controls

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudFeedback.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudListToolbar.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordList.java`
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudRecordEditor.java`

**Interfaces:**
- `CrudListToolbar.create(CrudRecordStore store, Runnable refresh, Runnable openEditor)` owns search input, add, refresh, and optional pagination controls.
- `CrudRecordList.create(CrudRecordStore store, Runnable refresh, Consumer<CrudRecord> edit, Consumer<CrudRecord> delete)` owns rows and emits row actions.
- `CrudRecordEditor.create(CrudRecord initial, Consumer<CrudRecord> save, Runnable cancel)` owns form fields and does not mutate the store directly.
- `CrudFeedback.create()` exposes `showSuccess(String)`, `showError(String)`, and `showInfo(String)` for operation messages.

- [ ] **Step 1: Add a compile-level usage test or minimal sample harness for the control signatures before implementation.**

  The harness should instantiate each control with a store and assert the returned root element is non-null; if the module cannot execute GWT UI tests, keep this as a package-local compile fixture and use the Maven compiler as the verification gate.

- [ ] **Step 2: Implement feedback and toolbar controls.**

  Use existing `Button`, `TextBox`, `Card`, `DivElement`, and Domino utility builders. Wire search changes to the store query and refresh callback; wire pagination buttons to `page` and disable previous/next at boundaries.

- [ ] **Step 3: Implement the record list.**

  Render id, name, owner, status, and description; add explicit Select/Edit/Delete buttons per row; show a clear empty filtered state when no records match.

- [ ] **Step 4: Implement the editor.**

  Prepopulate edit values, keep add mode blank, reject a blank name with visible error feedback, and invoke save only with a new `CrudRecord` draft.

- [ ] **Step 5: Compile the reusable controls.**

  Run: `mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile`

- [ ] **Step 6: Commit the reusable controls.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud
  git commit -m "feat: add reusable CRUD blueprint controls"
  ```

### Task 3: Implement the four concrete CRUD compositions

**Files:**
- Create: `demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud/CrudBlueprintView.java`
- Modify: the four existing `*Sample.java` files in `search_list_and_crud_screens`

**Interfaces:**
- Each public factory in `CrudBlueprintView` returns a `BaseDominoElement<HTMLDivElement, ?>` with its own store and local event wiring.
- Dialog variants open a real Domino `MessageDialog`/`AbstractDialog`-based editor surface and close only after a valid save or cancel.
- Top-section variant keeps the editor visible above the list and loads the selected row into it.
- Side-panel variant keeps the list visible while the selected row is edited in a persistent right-hand region.

- [ ] **Step 1: Add a failing composition contract check.**

  Assert through source-level checks that each catalog sample invokes its intended factory and that all four factories are present; use this check to prevent the four entries from silently reverting to `BlueprintSampleSupport.create(title, description, BlueprintSampleKind.CRUD, regions)`.

- [ ] **Step 2: Implement the short-list dialog composition.**

  Start with six records, a compact search toolbar, row actions, add/edit dialog, delete confirmation, and success/error feedback.

- [ ] **Step 3: Compile and manually inspect the short-list dialog composition.**

  Run the targeted Maven compile and inspect that the sample module generates successfully before continuing.

- [ ] **Step 4: Implement the short-list top-section composition.**

  Keep the editor above the six-row list; clicking a row loads its values, Save updates the row, Clear returns to add mode, and Add creates a new row.

- [ ] **Step 5: Implement the long-list dialog composition.**

  Use twenty-four records, a visible page-size indicator, previous/next controls, search, and the same valid-save/delete behavior as the short dialog while retaining the current page where possible.

- [ ] **Step 6: Implement the long-list side-panel composition.**

  Use twenty-four records in the main region and a persistent editor in the right region; selecting a row populates the panel without removing the list, and Save/Cancel update or restore the selection.

- [ ] **Step 7: Replace all four placeholder sample bodies.**

  Preserve their existing public `create()` methods and catalog descriptions, but return the appropriate concrete factory instead of the generic CRUD canvas.

- [ ] **Step 8: Run source mapping and compile checks.**

  ```bash
  rg -n "CrudBlueprintView\.(shortListWithDialog|shortListWithTopEditor|longListWithDialog|longListWithSideEditor)" demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search_list_and_crud_screens
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  ```

- [ ] **Step 9: Commit the four concrete samples.**

  ```bash
  git add demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/crud demo-samples/demo-samples-ui/src/main/java/org/dominokit/showcases/samples/blueprints/search_list_and_crud_screens
  git commit -m "feat: implement CRUD blueprint compositions"
  ```

### Task 4: Verify integration and handoff

**Files:**
- Verify: all files changed by Tasks 1–3.
- Modify: none unless verification identifies a concrete defect.

- [ ] **Step 1: Run the focused CRUD tests.**

  ```bash
  mvn -pl demo-samples/demo-samples-ui -Dtest=CrudRecordStoreTest test
  ```

- [ ] **Step 2: Run the affected reactor compile.**

  ```bash
  mvn -pl domino-demo/samples/samples-ui -am -DskipTests compile
  ```

- [ ] **Step 3: Run the full repository tests.**

  ```bash
  mvn test -q
  ```

- [ ] **Step 4: Verify the four menu mappings still exist and the worktree is clean.**

  ```bash
  rg -n "Short-list CRUD with dialog editor|Short-list CRUD with top-section editor|Long-list CRUD with dialog editor|Long-list CRUD with persistent side-panel editor" docs/superpowers/specs/2026-09-05-enterprise-screen-blueprints-design.md
  git diff --check
  git status --short --branch
  ```

- [ ] **Step 5: Report the worktree path, branch, commits, tests, and any environment warnings.**
