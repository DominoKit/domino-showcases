package org.dominokit.pages.ui.views.samples.datatable.sortsearch;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.sortsearch.*;

@UiView
public class TableSortAndSearchViewImpl extends SampleViewImpl {
    @Inject
    public TableSortAndSearchViewImpl() {
        register(DemoSample.of("datatable-sort-search", TableSortAndSearchSample.class, LazyProvider.of(TableSortAndSearchSample::create)));
    }
}