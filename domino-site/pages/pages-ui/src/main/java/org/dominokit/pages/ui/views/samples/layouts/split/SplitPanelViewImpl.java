package org.dominokit.pages.ui.views.samples.layouts.split;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.layouts.split.*;

@UiView
public class SplitPanelViewImpl extends SampleViewImpl {
    @Inject
    public SplitPanelViewImpl() {
        register(DemoSample.of("split-panel-horizontal", SplitPanelHorizontal.class, LazyProvider.of(SplitPanelHorizontal::create)));
        register(DemoSample.of("split-panel-vertical", SplitPanelVertical.class, LazyProvider.of(SplitPanelVertical::create)));
        register(DemoSample.of("split-panel-min-max", SplitPanelMinMax.class, LazyProvider.of(SplitPanelMinMax::create)));
        register(DemoSample.of("split-panel-multiple", SplitPanelMultiple.class, LazyProvider.of(SplitPanelMultiple::create)));
        register(DemoSample.of("split-panel-combined", SplitPanelCombined.class, LazyProvider.of(SplitPanelCombined::create)));
    }
}
