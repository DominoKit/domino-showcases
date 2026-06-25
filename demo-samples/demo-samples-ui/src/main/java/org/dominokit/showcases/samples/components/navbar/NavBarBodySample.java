package org.dominokit.showcases.samples.components.navbar;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_l_1;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_h_16;
import static org.dominokit.domino.ui.utils.Domino.dui_items_center;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_center;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_4;
import static org.dominokit.domino.ui.utils.Domino.dui_rounded_md;
import static org.dominokit.domino.ui.utils.Domino.dui_w_72;

public class NavBarBodySample extends BaseDominoElement<HTMLDivElement, NavBarBodySample> {

    private DivElement element;

    public static NavBarBodySample create() {
        return new NavBarBodySample();
    }

    public NavBarBodySample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_flex_col, dui_gap_4)
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_16, dui_p_x_4)
                                .appendChild(PrefixAddOn.of(Icons.view_headline().clickable()))
                                .appendChild(PostfixAddOn.of(Icons.bell().clickable()))
                                .appendChild(PostfixAddOn.of(Icons.cog().clickable()))
                                .withBody((parent, body) -> {
                                    body
                                            .addCss(dui_flex, dui_justify_center, dui_items_center)
                                            .appendChild(SearchBox.create()
                                                    .addCss(dui_w_72, dui_bg_l_1, dui_rounded_md, dui_fg_white, dui_h_12)
                                                    .setCssProperty("--dui-form-field-placeholder-color", "var(--dui-color-5")
                                            );
                                })
                        )
                );
        init(this);


    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
