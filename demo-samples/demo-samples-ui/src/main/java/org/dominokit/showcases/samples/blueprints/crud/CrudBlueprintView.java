package org.dominokit.showcases.samples.blueprints.crud;

import elemental2.dom.HTMLDivElement;
import java.util.List;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.Dialog;
import org.dominokit.domino.ui.dialogs.DialogSize;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

public final class CrudBlueprintView extends BaseDominoElement<HTMLDivElement, CrudBlueprintView> {

  private enum Mode {
    SHORT_DIALOG("Short list with dialog editor", false, false),
    SHORT_TOP("Short list with top-section editor", false, true),
    LONG_DIALOG("Long list with paginated dialog editor", true, false),
    LONG_SIDE("Long list with persistent side-panel editor", true, true);

    private final String title;
    private final boolean longList;
    private final boolean persistentEditor;

    Mode(String title, boolean longList, boolean persistentEditor) {
      this.title = title;
      this.longList = longList;
      this.persistentEditor = persistentEditor;
    }
  }

  private final Mode mode;
  private final CrudRecordStore store;
  private final DivElement root;
  private final DivElement listHost;
  private final DivElement editorHost;
  private final DivElement paginationHost;
  private final CrudFeedback feedback;
  private final CrudListToolbar toolbar;
  private int page;
  private String query = "";
  private String editorRecordId;

  private CrudBlueprintView(Mode mode) {
    this.mode = mode;
    this.store = CrudRecordStore.create(
        mode.longList ? CrudRecordFixtures.longList() : CrudRecordFixtures.shortList());
    this.page = 0;
    this.root = div().cssText("display: flex; flex-direction: column; gap: 12px; padding: 16px;")
        .appendChild(h(4).textContent(mode.title))
        .appendChild(p().textContent("Local data is intentionally editable so the layout and interaction pattern can be explored."));
    this.feedback = CrudFeedback.create();
    this.listHost = div();
    this.editorHost = div();
    this.paginationHost = div();
    this.toolbar = CrudListToolbar.create(store, this::refresh, () -> openEditor(null))
        .onSearchChanged(value -> {
          query = value == null ? "" : value;
          page = 0;
          refresh();
        });
    root.appendChild(toolbar).appendChild(feedback);
    if (mode.persistentEditor) {
      root.appendChild(div().cssText("display: grid; grid-template-columns: minmax(260px, 2fr) minmax(280px, 1fr); gap: 16px;")
          .appendChild(listHost)
          .appendChild(editorHost));
    } else {
      root.appendChild(editorHost).appendChild(listHost);
    }
    if (mode.longList) {
      root.appendChild(paginationHost);
    }
    if (mode == Mode.SHORT_TOP) {
      showEditor(null);
    }
    refresh();
    init(this);
  }

  public static CrudBlueprintView shortListWithDialog() {
    return new CrudBlueprintView(Mode.SHORT_DIALOG);
  }

  public static CrudBlueprintView shortListWithTopEditor() {
    return new CrudBlueprintView(Mode.SHORT_TOP);
  }

  public static CrudBlueprintView longListWithDialog() {
    return new CrudBlueprintView(Mode.LONG_DIALOG);
  }

  public static CrudBlueprintView longListWithSideEditor() {
    return new CrudBlueprintView(Mode.LONG_SIDE);
  }

  private void refresh() {
    CrudRecordStore.Page result = store.page(query, page, mode.longList ? 8 : 100);
    if (page != result.pageIndex()) {
      page = result.pageIndex();
    }
    List<CrudRecord> visible = mode.longList ? result.records() : store.search(query);
    listHost.clearElement();
    listHost.appendChild(CrudRecordList.create(
        visible, store, this::refresh, this::openEditor, this::confirmDelete));
    if (mode.longList) {
      renderPagination(result);
    }
    if (mode == Mode.LONG_SIDE) {
      store.selectedId().ifPresent(id -> store.find(id).ifPresent(record -> {
        if (!id.equals(editorRecordId)) {
          showEditor(record);
        }
      }));
    }
  }

  private void renderPagination(CrudRecordStore.Page result) {
    paginationHost.clearElement();
    paginationHost.cssText("display: flex; gap: 8px; align-items: center;");
    paginationHost.appendChild(Button.create("Previous")
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
        }));
    paginationHost.appendChild(p().textContent(
        "Page " + (result.pageIndex() + 1) + " of " + result.pageCount()
            + " · " + result.totalMatches() + " matching records"));
    paginationHost.appendChild(Button.create("Next")
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
  }

  private void openEditor(CrudRecord record) {
    if (mode.persistentEditor) {
      if (record != null) {
        store.select(record.id());
      }
      showEditor(record);
      return;
    }
    openDialog(record);
  }

  private void showEditor(CrudRecord record) {
    editorRecordId = record == null ? null : record.id();
    editorHost.clearElement();
    editorHost.appendChild(CrudRecordEditor.create(
        record,
        draft -> save(record, draft),
        () -> {
          editorRecordId = null;
          if (mode == Mode.SHORT_TOP) {
            showEditor(null);
          } else {
            editorHost.clearElement();
          }
        }));
  }

  private void openDialog(CrudRecord record) {
    Dialog[] dialogHolder = new Dialog[1];
    CrudRecordEditor editor = CrudRecordEditor.create(
        record,
        draft -> {
          save(record, draft);
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

  private void save(CrudRecord original, CrudRecord draft) {
    boolean saved = original == null ? store.add(draft) : store.update(draft);
    if (saved) {
      feedback.showSuccess((original == null ? "Added " : "Updated ") + draft.name());
      if (mode == Mode.SHORT_TOP) {
        showEditor(null);
      }
      if (mode == Mode.LONG_SIDE) {
        editorRecordId = draft.id();
      }
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
          if (mode == Mode.LONG_SIDE) {
            editorRecordId = null;
            editorHost.clearElement();
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
