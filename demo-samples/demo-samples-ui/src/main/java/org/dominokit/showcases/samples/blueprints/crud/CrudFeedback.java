package org.dominokit.showcases.samples.blueprints.crud;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;

public final class CrudFeedback extends BaseDominoElement<HTMLDivElement, CrudFeedback> {

  private final DivElement message;

  private CrudFeedback() {
    message = div().textContent("Ready");
    init(this);
  }

  public static CrudFeedback create() {
    return new CrudFeedback();
  }

  public CrudFeedback showSuccess(String text) {
    message.textContent("Success: " + text);
    return this;
  }

  public CrudFeedback showError(String text) {
    message.textContent("Error: " + text);
    return this;
  }

  public CrudFeedback showInfo(String text) {
    message.textContent(text);
    return this;
  }

  @Override
  public HTMLDivElement element() {
    return message.element();
  }
}
