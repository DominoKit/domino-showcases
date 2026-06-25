package org.dominokit.pages.ui.views.samples.datatable.scroll;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.scroll.*;

@UiView
public class ScrollLoadingViewImpl extends SampleViewImpl {
    @Inject
    public ScrollLoadingViewImpl() {
        register(DemoSample.of("datatable-scroll-loading", ScrollLoadingSample.class, LazyProvider.of(ScrollLoadingSample::create)));
    }
}