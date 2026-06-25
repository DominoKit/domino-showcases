package org.dominokit.pages.ui.views.samples.components.tabs;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.tabs.*;

@UiView
public class TabsViewImpl extends SampleViewImpl {
    @Inject
    public TabsViewImpl() {
        register(DemoSample.of("tabs-basic", BasicTabsSample.class, LazyProvider.of(BasicTabsSample::create)));
        register(DemoSample.of("tabs-alignment", TabsAlignmentSample.class, LazyProvider.of(TabsAlignmentSample::create)));
        register(DemoSample.of("tabs-closable", ClosableTabsSample.class, LazyProvider.of(ClosableTabsSample::create)));
        register(DemoSample.of("tabs-colored", ColoredTabsSample.class, LazyProvider.of(ColoredTabsSample::create)));
        register(DemoSample.of("tabs-content", TabsContentSample.class, LazyProvider.of(TabsContentSample::create)));
        register(DemoSample.of("tabs-animation", TabsAnimationSample.class, LazyProvider.of(TabsAnimationSample::create)));
        register(DemoSample.of("tabs-vertical", VerticalTabsSample.class, LazyProvider.of(VerticalTabsSample::create)));
    }
}