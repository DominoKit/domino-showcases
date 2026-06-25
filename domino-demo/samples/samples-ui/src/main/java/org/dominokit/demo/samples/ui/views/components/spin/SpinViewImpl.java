package org.dominokit.demo.samples.ui.views.components.spin;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.spin.SpinView;
        import org.dominokit.showcases.samples.components.spin.HorizontalSpinSample;
import org.dominokit.showcases.samples.components.spin.VerticalSpinSample;

        @UiView
        public class SpinViewImpl extends SamplePageView<SpinView.SpinUiHandlers>
            implements SpinView {

          @Inject
          public SpinViewImpl() {
            super("Spin", "Spin examples rendered from the shared demo-samples module.");
    addSample(HorizontalSpinSample.class, HorizontalSpinSample::create);
    addSample(VerticalSpinSample.class, VerticalSpinSample::create);
            initPage();
          }
        }
