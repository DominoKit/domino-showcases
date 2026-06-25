package org.dominokit.pages.ui.views.samples.datatable.fixed;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.fixed.*;

@UiView
public class FixedDataTableViewImpl extends SampleViewImpl {
    @Inject
    public FixedDataTableViewImpl() {
        register(DemoSample.of("datatable-fixed", FixedDataTableSample.class, LazyProvider.of(FixedDataTableSample::create)));
    }
}