package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;

final class PageLayoutSupport {

  private PageLayoutSupport() {}

  static DivElement root() {
    return div().cssText("display: flex; flex-direction: column; gap: 12px; padding: 16px;");
  }

  static DivElement header(String eyebrow, String title, String description) {
    return div()
        .appendChild(p().cssText("margin: 0; opacity: .7; text-transform: uppercase; letter-spacing: .08em;").textContent(eyebrow))
        .appendChild(h(4).textContent(title))
        .appendChild(p().textContent(description));
  }

  static Card surface(String title, String description) {
    return Card.create(title, description);
  }

  static DivElement stack() {
    return div().cssText("display: flex; flex-direction: column; gap: 10px;");
  }

  static DivElement row() {
    return div().cssText("display: flex; flex-wrap: wrap; gap: 8px; align-items: center;");
  }

  static DivElement grid(String columns) {
    return div().cssText("display: grid; grid-template-columns: " + columns + "; gap: 12px; align-items: start;");
  }

  static DivElement bordered(String extraCss) {
    return div().cssText(
        "border: 1px solid var(--dui-border-color, #d9e1ea); border-radius: 6px; padding: 12px; "
            + extraCss);
  }

  static DivElement status(String message) {
    return bordered("background: var(--dui-surface-color, #f7f9fb);").appendChild(p().textContent(message));
  }

  static Button action(String text, Runnable handler) {
    return Button.create(text).addClickListener(event -> handler.run());
  }
}
