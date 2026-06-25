package org.dominokit.showcases.samples.components.navbar;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_h_12;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.dui_p_x_4;

public class SimpleNavBarSample extends BaseDominoElement<HTMLDivElement, SimpleNavBarSample> {

    private DivElement element;

    public static SimpleNavBarSample create() {
        return new SimpleNavBarSample();
    }

    public SimpleNavBarSample() {
        this.element = div()
                .addCss(dui_p_2)
                .appendChild(div()
                        .addCss(dui_flex, dui_flex_col, dui_gap_4)
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_12, dui_p_x_4)
                        )
                        .appendChild(NavBar.create("Section title")
                                .addCss(dui_accent, dui_h_12, dui_p_x_4)
                                .setDescription("description goes here")
                        )
                );
        init(this);


    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
