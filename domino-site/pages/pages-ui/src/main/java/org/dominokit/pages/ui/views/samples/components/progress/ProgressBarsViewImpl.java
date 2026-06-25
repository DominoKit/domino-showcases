package org.dominokit.pages.ui.views.samples.components.progress;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.progress.*;

@UiView
public class ProgressBarsViewImpl extends SampleViewImpl {
    @Inject
    public ProgressBarsViewImpl() {
        register(DemoSample.of("progress-bars-basic", BasicProgressBarsSample.class, LazyProvider.of(BasicProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-colored", ColoredProgressBarsSample.class, LazyProvider.of(ColoredProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-striped", StripedProgressBarsSample.class, LazyProvider.of(StripedProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-animation", AnimatedProgressBarsSample.class, LazyProvider.of(AnimatedProgressBarsSample::create)));
        register(DemoSample.of("progress-bars-stacked", StackedProgressBarsSample.class, LazyProvider.of(StackedProgressBarsSample::create)));
    }
}