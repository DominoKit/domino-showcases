package org.dominokit.showcases.samples.components.buttons;

import static org.dominokit.domino.ui.style.FlexCss.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_m_1;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_primary;
import static org.dominokit.domino.ui.utils.Domino.dui_text_center;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BOTTOM_LEFT;
import static org.dominokit.domino.ui.menu.direction.DropDirection.BOTTOM_RIGHT;
import static org.dominokit.domino.ui.menu.direction.DropDirection.TOP_LEFT;
import static org.dominokit.domino.ui.menu.direction.DropDirection.TOP_RIGHT;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.DropdownButton;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.button.group.ButtonsGroup;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ButtonsDropDownSample extends BaseDominoElement<HTMLDivElement, ButtonsDropDownSample> {

  private DivElement element;

  public static ButtonsDropDownSample create() {
    return new ButtonsDropDownSample();
  }

  public ButtonsDropDownSample() {
    this.element = div().addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4, dui_justify_center, dui_items_center)
        .appendChild(BlockHeader.create("DROPDOWN BUTTONS").addCss(dui_text_center))
        .appendChild(Row.create()
            .span6(DropdownButton.create(
                    Button.create("Dropdown"),
                    createMenu(BOTTOM_RIGHT))
                .addCss(dui_m_1))
            .span6(DropdownButton.create(
                    Button.create(Icons.widgets(), "Dropdown"),
                    createMenu(BOTTOM_RIGHT))
                .addCss(dui_m_1)))
        .appendChild(BlockHeader.create("SPLIT BUTTONS").addCss(dui_text_center))
        .appendChild(Row.create()
            .span6(ButtonsGroup.create(
                    Button.create("DEFAULT"),
                    DropdownButton.create(
                            Button.create(Icons.chevron_down()),
                            createMenu(BOTTOM_RIGHT))
                    )
                .addCss(dui_m_1))
            .span6(ButtonsGroup.create(
                    Button.create(Icons.home()),
                    DropdownButton.create(
                            Button.create(Icons.chevron_down()),
                            createMenu(BOTTOM_RIGHT))
                        .addCss(dui_m_1))
                .addCss(dui_primary, dui_m_1)))
        .appendChild(BlockHeader.create("MENU POSITIONS").addCss(dui_text_center))
        .appendChild(Row.create()
            .span3(DropdownButton.create(
                    LinkButton.create("TOP LEFT").addCss(dui_m_1),
                    createMenu(TOP_LEFT)))
            .span3(DropdownButton.create(
                    LinkButton.create("TOP RIGHT").addCss(dui_m_1),
                    createMenu(TOP_RIGHT)))
            .span3(DropdownButton.create(
                    LinkButton.create("BOTTOM LEFT").addCss(dui_m_1),
                    createMenu(BOTTOM_LEFT)))
            .span3(DropdownButton.create(
                    LinkButton.create("BOTTOM RIGHT").addCss(dui_m_1),
                    createMenu(BOTTOM_RIGHT))))
        .appendChild(BlockHeader.create("LINK BUTTONS").addCss(dui_text_center))
        .appendChild(Row.create()
            .span4(LinkButton.create("DEFAULT")
                .addCss(dui_m_1))
            .span4(LinkButton.create(Icons.home(), "Home")
                .addCss(dui_m_1))
            .span4(LinkButton.create(Icons.arrow_right(), "Reversed")
                .addCss(dui_m_1)
                .setReversed(true)));
    init(this);
  }

  private Menu<String> createMenu(DropDirection direction) {
    return Menu.<String>create()
        .appendChild(MenuItem.create("Action"))
        .appendChild(MenuItem.create("Another action"))
        .appendChild(MenuItem.create("Something else here"))
        .setDropDirection(direction);
  }

  @Override
  public HTMLDivElement element() {
    return this.element.element();
  }
}
