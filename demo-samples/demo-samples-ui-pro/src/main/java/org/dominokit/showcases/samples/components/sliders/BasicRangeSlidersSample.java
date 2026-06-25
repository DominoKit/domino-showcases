package org.dominokit.showcases.samples.components.sliders;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.config.SlidersConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.sliders.ThumbStyle;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.pro.domino.ui.sliders.RangeSlider;
import org.gwtproject.i18n.client.NumberFormat;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_info;
import static org.dominokit.domino.ui.utils.Domino.dui_p_2;

public class BasicRangeSlidersSample extends BaseDominoElement<HTMLDivElement, BasicRangeSlidersSample> {

    private DivElement element;

    public static BasicRangeSlidersSample create() {
        return new BasicRangeSlidersSample();
    }

    public BasicRangeSlidersSample() {
        this.element = div().addCss(dui_p_2)
                .appendChild(RangeSlider.create(0, 100))
                .appendChild(RangeSlider.create(0, 100, 20)
                        .withThumb()
                )
                .appendChild(RangeSlider.create(0, 100)
                        .withThumb()
                        .setAutoHideThumb(false)
                        .setThumbStyle(ThumbStyle.FLAT)
                        .setConfig(new SlidersConfig() {
                            @Override
                            public String formatSliderThumbValue(double value) {
                                return NumberFormat.getFormat("#0.000").format(value);
                            }
                        })
                        .addChangeListener((oldValue, newValue) -> {
                            DomGlobal.console.info("Old : " + oldValue + " New : " + newValue);
                        })
                )
                .appendChild(RangeSlider.create(0, 100, 20, 70, 10)
                        .withThumb()
                )
        ;
        init(this);
    }

    private void showNotification(Double value) {
        Notification.create("Value " + value + " out of 200").addCss(dui_info).show();
    }

    @Override
    public HTMLDivElement element() {
        return this.element.element();
    }
}
