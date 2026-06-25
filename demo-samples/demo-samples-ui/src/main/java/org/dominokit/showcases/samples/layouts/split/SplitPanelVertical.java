package org.dominokit.showcases.samples.layouts.split;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.splitpanel.SplitPanel;
import org.dominokit.domino.ui.splitpanel.VSplitPanel;
import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.style.ColorsCss.dui_fg_color_inverted;
import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.FlexCss.dui_items_center;
import static org.dominokit.domino.ui.style.FlexCss.dui_justify_center;
import static org.dominokit.domino.ui.style.SizingCss.dui_h_full;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_2;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_l_2;
import static org.dominokit.domino.ui.utils.Domino.dui_h_96;
import static org.dominokit.domino.ui.utils.Domino.dui_w_full;
import static org.dominokit.domino.ui.utils.Domino.span;

public class SplitPanelVertical extends BaseDominoElement<HTMLDivElement, SplitPanelVertical> {

    private final DivElement element;
    private final CssClass demo_split_div = CompositeCssClass.of(dui_w_full, dui_h_full, dui_flex, dui_justify_center, dui_items_center, dui_fg_color_inverted);

    public static SplitPanelVertical create() {
        return new SplitPanelVertical();
    }

    public SplitPanelVertical() {
        this.element = div()
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div()
                                        .appendChild(span().textContent("Top"))
                                        .addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div()
                                        .appendChild(span().textContent("Bottom"))
                                        .addCss(demo_split_div, dui_bg_accent_d_2)))
                        .addCss(dui_h_96, dui_w_full)
                );

        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
