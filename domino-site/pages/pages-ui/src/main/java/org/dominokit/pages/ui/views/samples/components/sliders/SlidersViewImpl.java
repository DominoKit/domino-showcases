package org.dominokit.pages.ui.views.samples.components.sliders;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.sliders.*;

@UiView
public class SlidersViewImpl extends SampleViewImpl {
    @Inject
    public SlidersViewImpl() {
        register(DemoSample.of("sliders-basic", BasicSlidersSample.class, LazyProvider.of(BasicSlidersSample::create)));
        register(DemoSample.of("sliders-colored", ColoredSlidersSample.class, LazyProvider.of(ColoredSlidersSample::create)));
        register(DemoSample.of("sliders-picker", SlidersPickerSample.class, LazyProvider.of(SlidersPickerSample::create)));
    }
}