package org.dominokit.showcases.samples.helpers.dynamiccss;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_;
import static org.dominokit.domino.ui.utils.Domino.dui_p_;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/** Demonstrates runtime layout utilities with raw values and existing Domino spacing tokens. */
public class DynamicCssLayoutSample
    extends BaseDominoElement<HTMLDivElement, DynamicCssLayoutSample> {

  private final DivElement root;

  public static DynamicCssLayoutSample create() {
    return new DynamicCssLayoutSample();
  }

  private DynamicCssLayoutSample() {
    root =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_(12))
            .appendChild(
                div()
                    .addCss("dui-dynamic-css-layout-example")
                    .addCss(dui_p_("1.25rem"))
                    .appendChild(p("A raw CSS value: padding is generated from 1.25rem.")))
            .appendChild(
                div()
                    .addCss("dui-dynamic-css-layout-example")
                    .addCss(dui_p_(2))
                    .appendChild(p("An existing spacing token: padding reuses the existing spacing token for 2.")));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
