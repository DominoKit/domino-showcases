package org.dominokit.showcases.samples.blueprints.crud;

import elemental2.dom.HTMLDivElement;
import java.util.function.Consumer;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.p;

public final class CrudRecordEditor extends BaseDominoElement<HTMLDivElement, CrudRecordEditor> {

  private static int nextId = 100;

  private final DivElement root;
  private final TextBox name;
  private final TextBox owner;
  private final TextBox status;
  private final TextBox description;
  private final DivElement error;

  private CrudRecordEditor(CrudRecord initial, Consumer<CrudRecord> save, Runnable cancel) {
    CrudRecord value = initial == null
        ? CrudRecord.create("draft-" + nextId++, "", "", "Draft", "")
        : initial;
    name = TextBox.create("Name").withValue(value.name());
    owner = TextBox.create("Owner").withValue(value.owner());
    status = TextBox.create("Status").withValue(value.status());
    description = TextBox.create("Description").withValue(value.description());
    error = div().textContent("");
    root = div().cssText("display: flex; flex-direction: column; gap: 8px; min-width: 280px;")
        .appendChild(name)
        .appendChild(owner)
        .appendChild(status)
        .appendChild(description)
        .appendChild(error)
        .appendChild(div().cssText("display: flex; gap: 8px; justify-content: flex-end;")
            .appendChild(Button.create("Cancel").addClickListener(event -> cancel.run()))
            .appendChild(Button.create("Save").addClickListener(event -> {
              if (name.getValue() == null || name.getValue().trim().isEmpty()) {
                error.textContent("A record name is required before saving.");
                return;
              }
              error.textContent("");
              save.accept(CrudRecord.create(
                  value.id(), name.getValue(), owner.getValue(), status.getValue(), description.getValue()));
            })));
    init(this);
  }

  public static CrudRecordEditor create(
      CrudRecord initial, Consumer<CrudRecord> save, Runnable cancel) {
    return new CrudRecordEditor(initial, save, cancel);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
