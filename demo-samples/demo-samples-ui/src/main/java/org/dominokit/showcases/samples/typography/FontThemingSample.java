package org.dominokit.showcases.samples.typography;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.style.TypographyCss.dui_font_ibm_plex_sans;
import static org.dominokit.domino.ui.style.TypographyCss.dui_font_inter;
import static org.dominokit.domino.ui.style.TypographyCss.dui_font_open_sans;
import static org.dominokit.domino.ui.style.TypographyCss.dui_font_roboto;
import static org.dominokit.domino.ui.style.TypographyCss.dui_font_scope;
import static org.dominokit.domino.ui.style.TypographyCss.dui_font_source_sans_3;
import static org.dominokit.domino.ui.utils.Domino.code;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_blue_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

public class FontThemingSample extends BaseDominoElement<HTMLDivElement, FontThemingSample> {

    private final DivElement root;
    private final DivElement specimen;
    private final BlockHeader selection;
    private CssClass selectedFamily = dui_font_source_sans_3;

    public static FontThemingSample create() {
        return new FontThemingSample();
    }

    public FontThemingSample() {
        selection = BlockHeader.create("Selected family", "Source Sans 3");
        specimen = div()
                .addCss(dui_p_2, dui_flex, dui_flex_col, dui_gap_4)
                .appendChild(h(2).textContent("Font theming specimen"))
                .appendChild(p("The quick brown fox jumps over the lazy dog. 0123456789"))
                .appendChild(p("مرحباً بالعالم — هذا نص عربي لاختبار fallback للخطوط."))
                .appendChild(TextBox.create("Email").setPlaceholder("name@example.com"))
                .appendChild(Button.create("Continue").addCss(dui_accent))
                .appendChild(Alert.create().addCss(dui_bg_blue_grey, dui_fg_white)
                        .textContent("The selected family is inherited by component typography."))
                .appendChild(code().textContent("root.addCss(dui_font_scope, dui_font_source_sans_3)"));

        root = div()
                .addCss(dui_font_scope, dui_font_source_sans_3, dui_flex, dui_flex_col, dui_gap_4, dui_p_2)
                .appendChild(BlockHeader.create(
                        "Font theming",
                        "Switch the sample font through the public typed CSS classes."))
                .appendChild(selection)
                .appendChild(fontButtons())
                .appendChild(specimen);

        init(this);
    }

    private DivElement fontButtons() {
        return div().addCss(dui_flex, dui_gap_2)
                .appendChild(fontButton("Inter", dui_font_inter))
                .appendChild(fontButton("Open Sans", dui_font_open_sans))
                .appendChild(fontButton("Roboto", dui_font_roboto))
                .appendChild(fontButton("Source Sans 3", dui_font_source_sans_3))
                .appendChild(fontButton("IBM Plex Sans", dui_font_ibm_plex_sans));
    }

    private Button fontButton(String label, CssClass family) {
        return Button.create(label).addCss(dui_p_2).addClickListener(event -> selectFamily(label, family));
    }

    private void selectFamily(String label, CssClass family) {
        selectedFamily.remove(root);
        family.apply(root);
        selectedFamily = family;
        selection.setHeader("Selected family: " + label);
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
