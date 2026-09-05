package org.dominokit.showcases.samples.components.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.tabs.Tab;
import org.dominokit.domino.ui.tabs.TabsPanel;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_filled;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_minimal;
import static org.dominokit.domino.ui.utils.Domino.dui_emphasis_subtle;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_orange;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_pink;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_purple;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_red;
import static org.dominokit.domino.ui.utils.Domino.dui_accent_teal;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class ColoredTabsSample extends BaseDominoElement<HTMLDivElement, ColoredTabsSample> {

    private DivElement element;

    public static ColoredTabsSample create() {
        return new ColoredTabsSample();
    }

    public ColoredTabsSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_emphasis_subtle)
                                        .addCss(dui_accent_pink)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_emphasis_minimal)
                                        .addCss(dui_accent_teal)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_emphasis_filled)
                                        .addCss(dui_accent_purple)
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_red)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_orange)
                                )
                                .appendChild(TabsPanel.create()
                                        .appendChild(Tab.create("HOME"))
                                        .appendChild(Tab.create("PROFILE"))
                                        .appendChild(Tab.create("MESSAGES").activate())
                                        .appendChild(Tab.create("SETTINGS"))
                                        .addCss(dui_accent_blue_grey)
                                )
                        )
                )
        ;
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
