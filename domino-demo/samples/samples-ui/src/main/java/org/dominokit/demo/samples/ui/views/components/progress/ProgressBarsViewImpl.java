package org.dominokit.demo.samples.ui.views.components.progress;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.progress.ProgressBarsView;
        import org.dominokit.showcases.samples.components.progress.BasicProgressBarsSample;
import org.dominokit.showcases.samples.components.progress.ColoredProgressBarsSample;
import org.dominokit.showcases.samples.components.progress.StripedProgressBarsSample;
import org.dominokit.showcases.samples.components.progress.AnimatedProgressBarsSample;
import org.dominokit.showcases.samples.components.progress.StackedProgressBarsSample;

        @UiView
        public class ProgressBarsViewImpl extends SamplePageView<ProgressBarsView.ProgressBarsUiHandlers>
            implements ProgressBarsView {

          @Inject
          public ProgressBarsViewImpl() {
            super("Progress Bars", "Progress Bars examples rendered from the shared demo-samples module.");
    addSample(BasicProgressBarsSample.class, BasicProgressBarsSample::create);
    addSample(ColoredProgressBarsSample.class, ColoredProgressBarsSample::create);
    addSample(StripedProgressBarsSample.class, StripedProgressBarsSample::create);
    addSample(AnimatedProgressBarsSample.class, AnimatedProgressBarsSample::create);
    addSample(StackedProgressBarsSample.class, StackedProgressBarsSample::create);
            initPage();
          }
        }
