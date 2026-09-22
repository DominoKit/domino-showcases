package org.dominokit.showcases.samples.helpers.dynamiccss;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_clr_;
import static org.dominokit.domino.ui.utils.Domino.dui_clr_schm_;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_subtle;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DynamicColorScheme;

/** Demonstrates literal colors and reusable contextual dynamic color schemes. */
public class DynamicCssColorSample
    extends BaseDominoElement<HTMLDivElement, DynamicCssColorSample> {

  private final DivElement root;

  public static DynamicCssColorSample create() {
    return new DynamicCssColorSample();
  }

  private DynamicCssColorSample() {
    DynamicColorScheme brand = dui_clr_schm_("#3657d6");
    root =
        div()
            .addCss(dui_flex, dui_flex_col, dui_gap_2)
            .appendChild(
                div()
                    .addCss("dui-dynamic-css-color-example")
                    .appendChild(Button.create("A literal color").addCss(dui_clr_("#b64c8a"))))
            .appendChild(
                div()
                    .addCss("dui-dynamic-css-color-example")
                    .appendChild(
                        Button.create("A contextual color scheme")
                            .addCss(brand.getContextColor(), dui_emphasis_subtle)));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
