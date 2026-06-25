package org.dominokit.demo.samples.ui.views.forms.steppers;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.forms.steppers.SteppersView;
        import org.dominokit.showcases.samples.forms.steppers.HorizontalTrackSample;
import org.dominokit.showcases.samples.forms.steppers.VerticalTrackSample;
import org.dominokit.showcases.samples.forms.steppers.HorizontalStepperSample;
import org.dominokit.showcases.samples.forms.steppers.VerticalStepperSample;

        @UiView
        public class SteppersViewImpl extends SamplePageView<SteppersView.SteppersUiHandlers>
            implements SteppersView {

          @Inject
          public SteppersViewImpl() {
            super("Steppers", "Steppers examples rendered from the shared demo-samples module.");
    addSample(HorizontalTrackSample.class, HorizontalTrackSample::create);
    addSample(VerticalTrackSample.class, VerticalTrackSample::create);
    addSample(HorizontalStepperSample.class, HorizontalStepperSample::create);
    addSample(VerticalStepperSample.class, VerticalStepperSample::create);
            initPage();
          }
        }
