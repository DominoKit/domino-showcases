package org.dominokit.showcases.samples.components.buttons;

import static org.dominokit.domino.ui.style.FlexCss.dui_items_center;
import static org.dominokit.domino.ui.style.SizingCss.dui_w_64;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_m_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_text_center;
import static org.dominokit.domino.ui.utils.Domino.dui_vertical;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonsToolbar;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ButtonsGroupsSample extends BaseDominoElement<HTMLDivElement, ButtonsGroupsSample> {

  private DivElement element;

  public static ButtonsGroupsSample create() {
    return new ButtonsGroupsSample();
  }

  public ButtonsGroupsSample() {
    this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4, dui_justify_center, dui_items_center)
        .appendChild(BlockHeader.create("BUTTON GROUPS").addCss(dui_text_center))
        .appendChild(ButtonsGroup.create()
            .addCss(dui_m_1)
            .appendChild(Button.create(Icons.format_align_left()))
            .appendChild(Button.create(Icons.format_align_center()))
            .appendChild(Button.create(Icons.format_align_right()))
            .appendChild(Button.create(Icons.format_align_justify())))
        .appendChild(ButtonsGroup.create()
            .addCss(dui_primary, dui_m_1)
            .appendChild(Button.create("LEFT"))
            .appendChild(Button.create("MIDDLE"))
            .appendChild(Button.create("RIGHT")))
        .appendChild(BlockHeader.create("VERTICAL GROUP").addCss(dui_text_center))
        .appendChild(ButtonsGroup.create()
            .addCss(dui_vertical, dui_m_1)
            .appendChild(Button.create("Top"))
            .appendChild(Button.create("Middle"))
            .appendChild(Button.create("Bottom")))
        .appendChild(BlockHeader.create("TOOLBAR").addCss(dui_text_center))
        .appendChild(ButtonsToolbar.create()
            .appendChild(ButtonsGroup.create()
                .addCss(dui_m_1)
                .appendChild(Button.create("1"))
                .appendChild(Button.create("2"))
                .appendChild(Button.create("3")))
            .appendChild(ButtonsGroup.create()
                .addCss(dui_primary, dui_m_1)
                .appendChild(Button.create("4"))
                .appendChild(Button.create("5"))
                .appendChild(Button.create("6")))
            .appendChild(ButtonsGroup.create()
                .addCss(dui_m_1)
                .appendChild(Button.create(Icons.dots_vertical()))));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return this.element.element();
  }
}
