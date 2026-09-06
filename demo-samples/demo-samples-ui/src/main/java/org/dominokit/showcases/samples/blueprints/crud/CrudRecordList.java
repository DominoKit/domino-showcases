package org.dominokit.showcases.samples.blueprints.crud;

import elemental2.dom.HTMLDivElement;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.p;

public final class CrudRecordList extends BaseDominoElement<HTMLDivElement, CrudRecordList> {

  private final DivElement root;

  private CrudRecordList(
      List<CrudRecord> records,
      CrudRecordStore store,
      Runnable refresh,
      Consumer<CrudRecord> edit,
      Consumer<CrudRecord> delete) {
    root = div().css("display: flex; flex-direction: column; gap: 8px;");
    if (records.isEmpty()) {
      root.appendChild(p().textContent("No records match the current search."));
    }
    records.forEach(record -> root.appendChild(row(record, store, refresh, edit, delete)));
    init(this);
  }

  public static CrudRecordList create(
      CrudRecordStore store,
      Runnable refresh,
      Consumer<CrudRecord> edit,
      Consumer<CrudRecord> delete) {
    return create(store.records(), store, refresh, edit, delete);
  }

  public static CrudRecordList create(
      List<CrudRecord> records,
      CrudRecordStore store,
      Runnable refresh,
      Consumer<CrudRecord> edit,
      Consumer<CrudRecord> delete) {
    return new CrudRecordList(records, store, refresh, edit, delete);
  }

  private DivElement row(
      CrudRecord record,
      CrudRecordStore store,
      Runnable refresh,
      Consumer<CrudRecord> edit,
      Consumer<CrudRecord> delete) {
    return div().css("border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 10px;")
        .appendChild(div().css("display: flex; justify-content: space-between; gap: 8px; flex-wrap: wrap;")
            .appendChild(div().appendChild(p().textContent(record.name()))
                .appendChild(p().textContent(record.owner() + " · " + record.description())))
            .appendChild(div().css("display: flex; gap: 6px; align-items: center;")
                .appendChild(Badge.create(record.status()))
                .appendChild(Button.create("Select").addClickListener(event -> {
                  store.select(record.id());
                  refresh.run();
                }))
                .appendChild(Button.create("Edit").addClickListener(event -> edit.accept(record)))
                .appendChild(Button.create("Delete").addClickListener(event -> delete.accept(record)))));
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
