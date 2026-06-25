package org.dominokit.pages.ui.views.samples.components.carousel;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.carousel.*;

@UiView
public class CarouselViewImpl extends SampleViewImpl {
    @Inject
    public CarouselViewImpl() {
        register(DemoSample.of("carousel-basic", CarouselBasicSample.class, LazyProvider.of(CarouselBasicSample::create)));
        register(DemoSample.of("carousel-auto", AutoCarouselSample.class, LazyProvider.of(AutoCarouselSample::create)));
    }
}