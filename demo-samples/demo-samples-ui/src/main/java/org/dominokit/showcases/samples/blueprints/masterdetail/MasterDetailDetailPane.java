package org.dominokit.showcases.samples.blueprints.masterdetail;

import elemental2.dom.HTMLDivElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecord;
import org.dominokit.showcases.samples.blueprints.crud.CrudRecordEditor;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

public final class MasterDetailDetailPane extends BaseDominoElement<HTMLDivElement, MasterDetailDetailPane> {

  private final DivElement root;
  private final MasterDetailWorkspaceState state;
  private final Runnable refresh;
  private final Consumer<CrudRecord> save;
  private final boolean showRelated;
  private final boolean showActivity;
  private final boolean showInspector;
  private final boolean showComparison;
  private final boolean showPreviewToggle;

  private MasterDetailDetailPane(
      CrudRecord record,
      MasterDetailWorkspaceState state,
      Runnable refresh,
      Consumer<CrudRecord> save,
      boolean showRelated,
      boolean showActivity,
      boolean showInspector,
      boolean showComparison,
      boolean showPreviewToggle) {
    this.state = state;
    this.refresh = refresh;
    this.save = save;
    this.showRelated = showRelated;
    this.showActivity = showActivity;
    this.showInspector = showInspector;
    this.showComparison = showComparison;
    this.showPreviewToggle = showPreviewToggle;
    root = div().css("display: flex; flex-direction: column; gap: 12px; min-width: 0;");
    render(record);
    init(this);
  }

  public static MasterDetailDetailPane create(
      CrudRecord record,
      MasterDetailWorkspaceState state,
      Runnable refresh,
      Consumer<CrudRecord> save,
      boolean showRelated,
      boolean showActivity,
      boolean showInspector,
      boolean showComparison,
      boolean showPreviewToggle) {
    return new MasterDetailDetailPane(
        record, state, refresh, save, showRelated, showActivity, showInspector,
        showComparison, showPreviewToggle);
  }

  private void render(CrudRecord record) {
    root.clearElement();
    if (record == null) {
      root.appendChild(p().textContent("Select a record to inspect its details."));
      return;
    }
    root.appendChild(renderHeader(record));
    if (state.isEditMode()) {
      root.appendChild(CrudRecordEditor.create(
          record,
          draft -> save.accept(draft),
          () -> {
            state.setEditMode(false);
            refresh.run();
          }));
      return;
    }
    root.appendChild(renderTabs(record));
    if (showInspector && state.isInspectorPinned()) {
      root.appendChild(renderInspector(record));
    }
  }

  private DivElement renderHeader(CrudRecord record) {
    DivElement actions = div().css("display: flex; gap: 6px; flex-wrap: wrap; align-items: center;");
    actions.appendChild(Button.create("Previous").addClickListener(event -> {
      state.selectPrevious();
      refresh.run();
    }));
    actions.appendChild(Button.create("Next").addClickListener(event -> {
      state.selectNext();
      refresh.run();
    }));
    if (showPreviewToggle) {
      actions.appendChild(Button.create("Edit").addClickListener(event -> {
        state.setEditMode(true);
        refresh.run();
      }));
    }
    if (showInspector) {
      actions.appendChild(Button.create(state.isInspectorPinned() ? "Unpin inspector" : "Pin inspector")
          .addClickListener(event -> {
            state.setInspectorPinned(!state.isInspectorPinned());
            refresh.run();
          }));
    }
    return div().css("display: flex; justify-content: space-between; gap: 10px; flex-wrap: wrap;")
        .appendChild(div().appendChild(h(4).textContent(record.name()))
            .appendChild(p().textContent(record.owner() + " · " + record.description())))
        .appendChild(div().css("display: flex; gap: 6px; align-items: center;")
            .appendChild(Badge.create(record.status()))
            .appendChild(actions));
  }

  private DivElement renderTabs(CrudRecord record) {
    DivElement host = div().css("display: flex; flex-direction: column; gap: 10px;");
    DivElement tabs = div().css("display: flex; gap: 6px; flex-wrap: wrap;");
    tabs.appendChild(tab("Summary"));
    if (showRelated) {
      tabs.appendChild(tab("Related"));
    }
    if (showActivity) {
      tabs.appendChild(tab("Activity"));
    }
    if (showComparison) {
      tabs.appendChild(tab("Compare"));
    }
    host.appendChild(tabs);
    if ("Related".equals(state.activeTab()) && showRelated) {
      host.appendChild(renderRelated(record));
    } else if ("Activity".equals(state.activeTab()) && showActivity) {
      host.appendChild(renderActivity());
    } else if ("Compare".equals(state.activeTab()) && showComparison) {
      host.appendChild(renderComparison());
    } else {
      host.appendChild(renderSummary(record));
    }
    return host;
  }

  private Button tab(String label) {
    return Button.create(label).addClickListener(event -> {
      state.setActiveTab(label);
      refresh.run();
    });
  }

  private DivElement renderSummary(CrudRecord record) {
    return div().css("display: grid; grid-template-columns: repeat(auto-fit, minmax(180px, 1fr)); gap: 10px;")
        .appendChild(valueCard("Record ID", record.id()))
        .appendChild(valueCard("Owner", record.owner()))
        .appendChild(valueCard("Status", record.status()))
        .appendChild(valueCard("Description", record.description()));
  }

  private DivElement valueCard(String label, String value) {
    return div().css("border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 10px;")
        .appendChild(p().textContent(label))
        .appendChild(h(5).textContent(value));
  }

  private DivElement renderRelated(CrudRecord record) {
    DivElement host = div().css("display: flex; flex-direction: column; gap: 8px;");
    host.appendChild(p().textContent("Related entities are grouped here so the record remains the primary context."));
    for (MasterDetailFixtures.RelatedEntity entity : MasterDetailFixtures.relatedEntities(record.id())) {
      host.appendChild(div().css("border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 10px;")
          .appendChild(h(5).textContent(entity.label()))
          .appendChild(p().textContent(entity.kind() + " · " + entity.detail()))
          .appendChild(Button.create("Open related").addClickListener(event ->
              host.appendChild(p().textContent("Opened " + entity.label() + " in the related workspace.")))));
    }
    return host;
  }

  private DivElement renderActivity() {
    DivElement host = div().css("display: flex; flex-direction: column; gap: 8px;");
    TextBox filter = TextBox.create("Filter activity");
    DivElement eventsHost = div();
    filter.withInputElement((parent, input) -> input.onKeyUp(event ->
        renderActivityEvents(eventsHost, parent.getValue())));
    host.appendChild(filter)
        .appendChild(Button.create("Post note").addClickListener(event ->
            host.appendChild(p().textContent("A new note can be posted from this activity context."))))
        .appendChild(eventsHost);
    renderActivityEvents(eventsHost, "");
    return host;
  }

  private void renderActivityEvents(DivElement host, String query) {
    host.clearElement();
    for (MasterDetailFixtures.ActivityEvent event : state.activityMatches(query)) {
      host.appendChild(div().css("border-left: 3px solid var(--dui-primary-color, #4c6fff); padding: 6px 10px;")
          .appendChild(h(5).textContent(event.summary()))
          .appendChild(p().textContent(event.type() + " · " + event.actor() + " · " + event.timestamp())));
    }
  }

  private DivElement renderInspector(CrudRecord record) {
    DivElement host = div().css("border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 10px;");
    return host
        .appendChild(h(5).textContent("Pinned inspector"))
        .appendChild(p().textContent("Contextual actions stay visible while the record content changes."))
        .appendChild(Button.create("Reassign owner").addClickListener(event ->
            host.appendChild(p().textContent("Reassignment workflow opened for " + record.name() + "."))))
        .appendChild(p().textContent("Owner: " + record.owner() + " · Status: " + record.status()));
  }

  private DivElement renderComparison() {
    DivElement host = div().css("display: flex; flex-direction: column; gap: 8px;");
    host.appendChild(p().textContent("Choose up to three records to compare side by side."));
    DivElement controls = div().css("display: flex; gap: 6px; flex-wrap: wrap;");
    for (CrudRecord candidate : state.recordStore().records()) {
      String label = state.comparedIds().contains(candidate.id()) ? "Remove " : "Compare ";
      controls.appendChild(Button.create(label + candidate.name()).addClickListener(event -> {
        state.toggleCompared(candidate.id());
        refresh.run();
      }));
    }
    host.appendChild(controls);
    DivElement columns = div().css("display: grid; grid-template-columns: repeat(auto-fit, minmax(180px, 1fr)); gap: 8px;");
    for (String id : state.comparedIds()) {
      state.recordStore().find(id).ifPresent(record -> columns.appendChild(valueCard(record.name(),
          record.owner() + " · " + record.status())));
    }
    host.appendChild(columns);
    return host;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
