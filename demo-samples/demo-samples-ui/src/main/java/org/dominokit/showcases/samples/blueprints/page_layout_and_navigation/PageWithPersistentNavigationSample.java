package org.dominokit.showcases.samples.blueprints.page_layout_and_navigation;

import static org.dominokit.domino.ui.style.DisplayCss.dui_border_none;
import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.FlexCss.dui_flex_col;
import static org.dominokit.domino.ui.style.SizingCss.dui_h_full;
import static org.dominokit.domino.ui.style.SizingCss.dui_w_full;
import static org.dominokit.domino.ui.style.SpacingUtilitiesCss.dui_gap_2;
import static org.dominokit.domino.ui.style.SpacingUtilitiesCss.dui_p_0;
import static org.dominokit.domino.ui.style.TypographyCss.dui_font_size_5;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.showcases.samples.SampleText;

public class PageWithPersistentNavigationSample
    extends BaseDominoElement<HTMLDivElement, PageWithPersistentNavigationSample> {

  private final DivElement root;

  public static PageWithPersistentNavigationSample create() {
    return new PageWithPersistentNavigationSample();
  }

  private PageWithPersistentNavigationSample() {
    this.root = div().addCss(dui_h_full)
        .appendChild(Row.create()
            .addCss(dui_gap_2)
            .span4(Card.create()
                .withBody((card, body) -> body.addCss(dui_p_0))
                .appendChild(Menu.<String>create()
                    .addCss(dui_w_full, dui_border_none)
                    .setIcon(Icons.menu())
                    .setTitle("Menu")
                    .withHeader((menu, header) -> header
                        .appendChild(PostfixAddOn.of(Icons.mouse_right_click()
                            .clickable()
                            .addClickListener(evt -> Notification.create("Clickable action").show())))
                        .appendChild(PostfixAddOn.of(Icons.mouse_right_click()
                            .clickable()
                            .addClickListener(evt -> Notification.create("Clickable action").show()))))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("new-key")
                        .withValue("new-value"))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("open-key")
                        .withValue("open-value")
                        .appendChild(PrefixAddOn.of(Icons.folder_open().addCss(dui_font_size_5))))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("close-key")
                        .withValue("close-value")
                        .appendChild(PrefixAddOn.of(Icons.close_box().addCss(dui_font_size_5))))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("close-all-key")
                        .withValue("close-all-value")
                        .appendChild(PrefixAddOn.of(Icons.close_box_multiple().addCss(dui_font_size_5))))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("structure-key")
                        .withValue("structure-value")
                        .appendChild(PrefixAddOn.of(Icons.folder_cog().addCss(dui_font_size_5))))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("settings-key")
                        .withValue("settings-value")
                        .appendChild(PrefixAddOn.of(Icons.cog().addCss(dui_font_size_5))))
                    .appendChild(MenuItem.<String>create("Menu item", "Description for the menu item")
                        .setKey("cache-key")
                        .withValue("cache-value"))
                    .appendChild(MenuItem.<String>create("Menu item")
                        .setKey("restart-key")
                        .withValue("restart-value")
                        .appendChild(PostfixAddOn.of(Icons.information()
                            .addCss(dui_font_size_5)
                            .setTooltip("Just a tool tip!"))))))
            .span8(div().addCss(dui_flex, dui_flex_col, dui_gap_2)
                .appendChild(Card.create("Content", "Content description")
                    .appendChild(p(SampleText.SAMPLE_TEXT))
                    .appendChild(p(SampleText.SAMPLE_TEXT)))
                .appendChild(Card.create("Content", "Content description")
                    .appendChild(p(SampleText.SAMPLE_TEXT))
                    .appendChild(p(SampleText.SAMPLE_TEXT)))));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return this.root.element();
  }
}
