package org.dominokit.pages.ui.views.samples.datatable.summary;

//import org.dominokit.brix.annotations.UiView;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
//import org.dominokit.pages.client.presenters.samples.datatable.TableSummaryProxy;
//import org.dominokit.pages.ui.views.DemoSample;
//import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.summary.*;
//import org.dominokit.pages.ui.views.SampleViewImpl;

@UiView
public class TableSummaryViewImpl extends SampleViewImpl {
    @Inject
    public TableSummaryViewImpl() {
        register(DemoSample.of("datatable-summary", TableSummarySample.class, LazyProvider.of(TableSummarySample::create)));
    }
}