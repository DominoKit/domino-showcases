package org.dominokit.demo.samples.ui.views.components.sliders;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.sliders.SlidersView;
        import org.dominokit.showcases.samples.components.sliders.BasicSlidersSample;
import org.dominokit.showcases.samples.components.sliders.ColoredSlidersSample;
import org.dominokit.showcases.samples.components.sliders.SlidersPickerSample;

        @UiView
        public class SlidersViewImpl extends SamplePageView<SlidersView.SlidersUiHandlers>
            implements SlidersView {

          @Inject
          public SlidersViewImpl() {
            super("Sliders", "Sliders examples rendered from the shared demo-samples module.");
    addSample(BasicSlidersSample.class, BasicSlidersSample::create);
    addSample(ColoredSlidersSample.class, ColoredSlidersSample::create);
    addSample(SlidersPickerSample.class, SlidersPickerSample::create);
            initPage();
          }
        }
