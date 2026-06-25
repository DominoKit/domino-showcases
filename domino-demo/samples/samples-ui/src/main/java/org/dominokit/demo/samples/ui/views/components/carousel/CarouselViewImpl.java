package org.dominokit.demo.samples.ui.views.components.carousel;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.carousel.CarouselView;
        import org.dominokit.showcases.samples.components.carousel.CarouselBasicSample;
import org.dominokit.showcases.samples.components.carousel.AutoCarouselSample;

        @UiView
        public class CarouselViewImpl extends SamplePageView<CarouselView.CarouselUiHandlers>
            implements CarouselView {

          @Inject
          public CarouselViewImpl() {
            super("Carousel", "Carousel examples rendered from the shared demo-samples module.");
    addSample(CarouselBasicSample.class, CarouselBasicSample::create);
    addSample(AutoCarouselSample.class, AutoCarouselSample::create);
            initPage();
          }
        }
