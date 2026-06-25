package org.dominokit.pages.ui.views.samples.components.sliders;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.sliders.*;

@UiView
public class RangeSlidersViewImpl extends SampleViewImpl {
    @Inject
    public RangeSlidersViewImpl() {
        register(DemoSample.of("range-slider-basic", BasicRangeSlidersSample.class, LazyProvider.of(BasicRangeSlidersSample::create)));
    }
}