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
        .appendChild(ButtonsGroup.create(
            Button.create(Icons.format_align_left()),
            Button.create(Icons.format_align_center()),
            Button.create(Icons.format_align_right()),
            Button.create(Icons.format_align_justify()))
            .addCss(dui_m_1))
        .appendChild(ButtonsGroup.create(
            Button.create("LEFT"),
            Button.create("MIDDLE"),
            Button.create("RIGHT"))
            .addCss(dui_primary, dui_m_1))
        .appendChild(BlockHeader.create("VERTICAL GROUP").addCss(dui_text_center))
        .appendChild(ButtonsGroup.create(
            Button.create("Top"),
            Button.create("Middle"),
            Button.create("Bottom"))
            .addCss(dui_vertical, dui_m_1))
        .appendChild(BlockHeader.create("TOOLBAR").addCss(dui_text_center))
        .appendChild(ButtonsToolbar.create()
            .appendChild(
                ButtonsGroup.create(
                    Button.create("1"),
                    Button.create("2"),
                    Button.create("3")).addCss(dui_m_1),
                ButtonsGroup.create(
                    Button.create("4"),
                    Button.create("5"),
                    Button.create("6")).addCss(dui_primary, dui_m_1),
                ButtonsGroup.create(Button.create(Icons.dots_vertical())).addCss(dui_m_1)));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return this.element.element();
  }
}
