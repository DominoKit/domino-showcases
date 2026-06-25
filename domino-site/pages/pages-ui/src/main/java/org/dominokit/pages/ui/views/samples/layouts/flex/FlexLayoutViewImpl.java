package org.dominokit.pages.ui.views.samples.layouts.flex;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.layouts.flex.*;

@UiView
public class FlexLayoutViewImpl extends SampleViewImpl {
    @Inject
    public FlexLayoutViewImpl() {
        register(DemoSample.of("flex-layout-playground", FlexLayoutPlayground.class, LazyProvider.of(FlexLayoutPlayground::create)));
        register(DemoSample.of("flex-item-playground", FlexItemPlayground.class, LazyProvider.of(FlexItemPlayground::create)));
    }
}
