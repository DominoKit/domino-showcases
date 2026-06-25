package org.dominokit.pages.ui.views.samples.datatable.header;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.header.*;

@UiView
public class TableHeaderViewImpl extends SampleViewImpl {
    @Inject
    public TableHeaderViewImpl() {
        register(DemoSample.of("datatable-header-bar", TableHeaderBarSample.class, LazyProvider.of(TableHeaderBarSample::create)));
    }
}