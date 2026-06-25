package org.dominokit.pages.ui.views.samples.datatable.emptystate;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.emptystate.*;

@UiView
public class EmptyStateTableViewImpl extends SampleViewImpl {
    @Inject
    public EmptyStateTableViewImpl() {
        register(DemoSample.of("datatable-empty-state", EmptyStateTableSample.class, LazyProvider.of(EmptyStateTableSample::create)));
    }
}