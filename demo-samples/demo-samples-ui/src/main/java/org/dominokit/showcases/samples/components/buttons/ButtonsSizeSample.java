package org.dominokit.showcases.samples.components.buttons;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_large;
import static org.dominokit.domino.ui.utils.Domino.dui_m_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_small;
import static org.dominokit.domino.ui.utils.Domino.dui_text_center;
import static org.dominokit.domino.ui.utils.Domino.dui_xsmall;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ButtonsSizeSample extends BaseDominoElement<HTMLDivElement, ButtonsSizeSample> {

  private DivElement element;

  public static ButtonsSizeSample create() {
    return new ButtonsSizeSample();
  }

  public ButtonsSizeSample() {
    this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4, dui_justify_center)
        .appendChild(BlockHeader.create("BUTTON SIZES").addCss(dui_text_center))
        .appendChild(Row.create()
            .span3(Button.create("LARGE")
                .addCss(dui_large, dui_m_1))
            .span3(Button.create("DEFAULT")
                .addCss(dui_m_1))
            .span3(Button.create("SMALL")
                .addCss(dui_small, dui_m_1))
            .span3(Button.create("XSMALL")
                .addCss(dui_xsmall, dui_m_1)))
        .appendChild(BlockHeader.create("ICON SIZES").addCss(dui_text_center))
        .appendChild(Row.create()
            .span3(Button.create(Icons.home())
                .circle()
                .addCss(dui_large, dui_m_1))
            .span3(Button.create(Icons.home())
                .circle()
                .addCss(dui_m_1))
            .span3(Button.create(Icons.home())
                .circle()
                .addCss(dui_small, dui_m_1))
            .span3(Button.create(Icons.home())
                .circle()
                .addCss(dui_xsmall, dui_m_1)));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return this.element.element();
  }
}
