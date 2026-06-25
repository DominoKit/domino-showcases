package org.dominokit.pages.ui.views.samples.components.pagination;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.pagination.*;

@UiView
public class PaginationViewImpl extends SampleViewImpl {
    @Inject
    public PaginationViewImpl() {
        register(DemoSample.of("pagination-basic", BasicPaginationSample.class, LazyProvider.of(BasicPaginationSample::create)));
        register(DemoSample.of("pagination-scrolling", ScrollingPaginationSample.class, LazyProvider.of(ScrollingPaginationSample::create)));
        register(DemoSample.of("pagination-advanced", AdvancedPaginationSample.class, LazyProvider.of(AdvancedPaginationSample::create)));
        register(DemoSample.of("pagination-pager", PagerPaginationSample.class, LazyProvider.of(PagerPaginationSample::create)));
    }
}