package org.dominokit.showcases.samples.blueprints.masterdetail;

import elemental2.dom.HTMLDivElement;
import java.util.List;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.showcases.samples.blueprints.crud.CrudFeedback;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecord;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordEditor;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordFixtures;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordList;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordStore;
import org.dominokit.showcases.samples.blueprints.crud.CrudListToolbar;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

public final class MasterDetailBlueprintView extends BaseDominoElement<HTMLDivElement, MasterDetailBlueprintView> {

  private enum Mode {
    PERSISTENT_LIST("Master-detail with persistent record list", false, false, false, false, false, false),
    RECORD_PAGE("Master-detail record page", false, true, false, false, false, true),
    RELATED("Record overview with related entities", false, true, true, false, false, true),
    ACTIVITY("Record page with activity timeline", true, true, false, true, false, true),
    INSPECTOR("Record page with side inspector", false, true, false, false, true, true),
    PREVIEW_EDIT("Record split view with preview and edit modes", false, false, false, false, false, true),
    COMPARE("Multi-record comparison workspace", false, true, false, false, false, true);

    private final String title;
    private final boolean longList;
    private final boolean showRelated;
    private final boolean showActivity;
    private final boolean showInspector;
    private final boolean showComparison;
    private final boolean showPreviewToggle;

    Mode(
        String title,
        boolean longList,
        boolean showRelated,
        boolean showActivity,
        boolean showInspector,
        boolean showComparison,
        boolean showPreviewToggle) {
      this.title = title;
      this.longList = longList;
      this.showRelated = showRelated;
      this.showActivity = showActivity;
      this.showInspector = showInspector;
      this.showComparison = showComparison;
      this.showPreviewToggle = showPreviewToggle;
    }
  }

  private final Mode mode;
  private final CrudRecordStore store;
  private final MasterDetailWorkspaceState state;
  private final DivElement root;
  private final DivElement listHost;
  private final DivElement detailHost;
  private final CrudFeedback feedback;
  private final CrudListToolbar toolbar;
  private int page;
  private String query = "";

  private MasterDetailBlueprintView(Mode mode) {
    this.mode = mode;
    store = CrudRecordStore.create(mode.longList ? CrudRecordFixtures.longList() : CrudRecordFixtures.shortList());
    state = MasterDetailWorkspaceState.create(store);
    store.records().stream().findFirst().ifPresent(record -> store.select(record.id()));
    page = 0;
    root = div().css("display: flex; flex-direction: column; gap: 12px; padding: 16px;")
        .appendChild(h(4).textContent(mode.title))
        .appendChild(p().textContent(description(mode)));
    listHost = div();
    detailHost = div();
    feedback = CrudFeedback.create();
    toolbar = CrudListToolbar.create(store, this::refresh, () -> openEditor(null))
        .onSearchChanged(value -> {
          query = value == null ? "" : value;
          page = 0;
          refresh();
        });
    root.appendChild(toolbar).appendChild(feedback)
        .appendChild(div().css("display: grid; grid-template-columns: minmax(260px, 1fr) minmax(320px, 2fr); gap: 16px; align-items: start;")
            .appendChild(listHost)
            .appendChild(detailHost));
    refresh();
    init(this);
  }

  public static MasterDetailBlueprintView persistentRecordList() {
    return new MasterDetailBlueprintView(Mode.PERSISTENT_LIST);
  }

  public static MasterDetailBlueprintView recordPage() {
    return new MasterDetailBlueprintView(Mode.RECORD_PAGE);
  }

  public static MasterDetailBlueprintView relatedEntities() {
    return new MasterDetailBlueprintView(Mode.RELATED);
  }

  public static MasterDetailBlueprintView activityTimeline() {
    return new MasterDetailBlueprintView(Mode.ACTIVITY);
  }

  public static MasterDetailBlueprintView sideInspector() {
    return new MasterDetailBlueprintView(Mode.INSPECTOR);
  }

  public static MasterDetailBlueprintView previewAndEdit() {
    return new MasterDetailBlueprintView(Mode.PREVIEW_EDIT);
  }

  public static MasterDetailBlueprintView compareRecords() {
    return new MasterDetailBlueprintView(Mode.COMPARE);
  }

  public static MasterDetailHierarchyPane hierarchyExplorer() {
    return MasterDetailHierarchyPane.create(
        MasterDetailWorkspaceState.create(CrudRecordStore.create(CrudRecordFixtures.shortList())));
  }

  private String description(Mode value) {
    switch (value) {
      case PERSISTENT_LIST:
        return "A searchable record list stays visible beside the selected record for rapid scanning and navigation.";
      case RECORD_PAGE:
        return "A record header and tabbed detail sections provide a focused page while keeping list context available.";
      case RELATED:
        return "Summary information and related entities are grouped into a navigable record overview.";
      case ACTIVITY:
        return "A chronological activity stream supports filtering, notes, and record-centered follow-up.";
      case INSPECTOR:
        return "A pinned side inspector exposes contextual metadata and actions without losing the record context.";
      case PREVIEW_EDIT:
        return "The same detail pane switches between a read-only preview and an inline edit state.";
      case COMPARE:
        return "A shared comparison tab lets users align up to three records and switch values in context.";
      default:
        return "A reusable master-detail workspace composition.";
    }
  }

  private void refresh() {
    CrudRecordStore.Page result = store.page(query, page, mode.longList ? 8 : 100);
    page = result.pageIndex();
    List<CrudRecord> visible = mode.longList ? result.records() : store.search(query);
    listHost.clearElement();
    listHost.appendChild(CrudRecordList.create(
        visible,
        store,
        this::refresh,
        this::editRecord,
        this::confirmDelete));
    if (mode.longList) {
      listHost.appendChild(renderPagination(result));
    }
    detailHost.clearElement();
    state.selectedRecord().ifPresent(record -> detailHost.appendChild(MasterDetailDetailPane.create(
        record,
        state,
        this::refresh,
        this::saveRecord,
        mode.showRelated,
        mode.showActivity,
        mode.showInspector,
        mode.showComparison,
        mode.showPreviewToggle)));
    if (!state.selectedRecord().isPresent()) {
      detailHost.appendChild(p().textContent("Select a record to inspect its details."));
    }
  }

  private DivElement renderPagination(CrudRecordStore.Page result) {
    DivElement pagination = div().css("display: flex; gap: 8px; align-items: center; margin-top: 8px;")
        .appendChild(Button.create("Previous")
            .apply(button -> {
              if (result.pageIndex() == 0) {
                button.disable();
              }
            })
            .addClickListener(event -> {
              if (page > 0) {
                page--;
                refresh();
              }
            }))
        .appendChild(p().textContent("Page " + (result.pageIndex() + 1) + " of " + result.pageCount()
            + " · " + result.totalMatches() + " matching records"))
        .appendChild(Button.create("Next")
            .apply(button -> {
              if (result.pageIndex() >= result.pageCount() - 1) {
                button.disable();
              }
            })
            .addClickListener(event -> {
              if (page < result.pageCount() - 1) {
                page++;
                refresh();
              }
            }));
    return pagination;
  }

  private void editRecord(CrudRecord record) {
    store.select(record.id());
    if (mode.showPreviewToggle) {
      state.setEditMode(true);
      refresh();
    } else {
      openEditor(record);
    }
  }

  private void openEditor(CrudRecord record) {
    Dialog[] dialogHolder = new Dialog[1];
    CrudRecordEditor editor = CrudRecordEditor.create(
        record,
        draft -> {
          saveRecord(draft);
          dialogHolder[0].close();
        },
        () -> dialogHolder[0].close());
    Dialog dialog = Dialog.create()
        .setStretchWidth(DialogSize.MEDIUM)
        .withHeader((parent, header) -> header.appendChild(NavBar.create(record == null ? "Add record" : "Edit record")))
        .appendChild(editor);
    dialogHolder[0] = dialog;
    dialog.open();
  }

  private void saveRecord(CrudRecord draft) {
    boolean updated = store.find(draft.id()).isPresent();
    boolean saved = updated ? store.update(draft) : store.add(draft);
    if (saved) {
      state.setEditMode(false);
      store.select(draft.id());
      feedback.showSuccess((updated ? "Updated " : "Added ") + draft.name());
      refresh();
    } else {
      feedback.showError("The record could not be saved.");
    }
  }

  private void confirmDelete(CrudRecord record) {
    MessageDialog.create()
        .setTitle("Delete record?")
        .setMessage("Delete " + record.name() + " from the local sample data?")
        .onConfirm(dialog -> {
          store.delete(record.id());
          feedback.showSuccess("Deleted " + record.name());
          if (!store.selectedId().isPresent()) {
            store.records().stream().findFirst().ifPresent(next -> store.select(next.id()));
          }
          refresh();
          dialog.close();
        })
        .open();
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
