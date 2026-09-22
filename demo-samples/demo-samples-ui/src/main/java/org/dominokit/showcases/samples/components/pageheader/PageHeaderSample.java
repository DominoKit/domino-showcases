package org.dominokit.showcases.samples.components.pageheader;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.PageHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Demonstrates PageHeader title, description, and action composition. */
public class PageHeaderSample extends BaseDominoElement<HTMLDivElement, PageHeaderSample> {

  private final DivElement root;

  public static PageHeaderSample create() {
    return new PageHeaderSample();
  }

  private PageHeaderSample() {
    root =
        div()
            .addCss(dui_p_2)
            .appendChild(
                PageHeader.create("Orders")
                    .setDescription("Review and manage your customer orders.")
                    .withPostfixElement(
                        (parent, postfix) -> postfix.appendChild(Button.create("Create order"))));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
