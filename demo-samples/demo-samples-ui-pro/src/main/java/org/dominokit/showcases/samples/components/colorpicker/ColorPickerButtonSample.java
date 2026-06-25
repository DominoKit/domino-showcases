package org.dominokit.showcases.samples.components.colorpicker;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.colorpicker.ColorPickerButton;

import static org.dominokit.domino.ui.style.GenericCss.dui_accent;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class ColorPickerButtonSample extends BaseDominoElement<HTMLDivElement, ColorPickerButtonSample> {

    private DivElement element;

    public static ColorPickerButtonSample create() {
        return new ColorPickerButtonSample();
    }

    public ColorPickerButtonSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(ColorPickerButton.create("Pick color").addCss(dui_accent));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
