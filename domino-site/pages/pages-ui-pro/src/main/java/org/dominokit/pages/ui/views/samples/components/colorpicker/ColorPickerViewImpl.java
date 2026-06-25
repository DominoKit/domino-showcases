package org.dominokit.pages.ui.views.samples.components.colorpicker;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.colorpicker.*;

@UiView
public class ColorPickerViewImpl extends SampleViewImpl {
    @Inject
    public ColorPickerViewImpl() {
        register(DemoSample.of("colorpicker-basic", BasicColorPickerSample.class, LazyProvider.of(BasicColorPickerSample::create)));
        register(DemoSample.of("colorpicker-button", ColorPickerButtonSample.class, LazyProvider.of(ColorPickerButtonSample::create)));
        register(DemoSample.of("colorpicker-popover", ColorPickerPopoverSample.class, LazyProvider.of(ColorPickerPopoverSample::create)));
    }
}