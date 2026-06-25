package org.dominokit.pages.ui.views.samples.datatable.pagination;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.pagination.*;

@UiView
public class TablePaginationViewImpl extends SampleViewImpl {
    @Inject
    public TablePaginationViewImpl() {
        register(DemoSample.of("datatable-pagination-simple", SimplePaginationSample.class, LazyProvider.of(SimplePaginationSample::create)));
        register(DemoSample.of("datatable-pagination-scrolling", ScrollingPaginationSample.class, LazyProvider.of(ScrollingPaginationSample::create)));
        register(DemoSample.of("datatable-pagination-advanced", AdvancedPaginationSample.class, LazyProvider.of(AdvancedPaginationSample::create)));
    }
}