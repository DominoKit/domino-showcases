package org.dominokit.showcases.samples.blueprints.crud;

import elemental2.dom.HTMLDivElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;

public final class CrudListToolbar extends BaseDominoElement<HTMLDivElement, CrudListToolbar> {

  private final DivElement root;
  private final TextBox searchBox;
  private Consumer<String> searchListener = query -> {};

  private CrudListToolbar(CrudRecordStore store, Runnable refresh, Runnable openEditor) {
    searchBox = TextBox.create("Search records")
        .withInputElement((parent, input) -> input.onKeyUp(event -> searchListener.accept(parent.getValue())));
    root = div().cssText("display: flex; gap: 8px; align-items: center; flex-wrap: wrap;")
        .appendChild(searchBox)
        .appendChild(Button.create("Add record").addClickListener(event -> openEditor.run()))
        .appendChild(Button.create("Refresh").addClickListener(event -> refresh.run()));
    init(this);
  }

  public static CrudListToolbar create(
      CrudRecordStore store, Runnable refresh, Runnable openEditor) {
    return new CrudListToolbar(store, refresh, openEditor);
  }

  public CrudListToolbar onSearchChanged(Consumer<String> listener) {
    searchListener = listener == null ? query -> {} : listener;
    return this;
  }

  public String query() {
    return searchBox.getValue();
  }

  public CrudListToolbar clearSearch() {
    searchBox.clear();
    searchListener.accept("");
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
