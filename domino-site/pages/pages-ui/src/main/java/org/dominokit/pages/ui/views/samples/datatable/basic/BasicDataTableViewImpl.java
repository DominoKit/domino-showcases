package org.dominokit.pages.ui.views.samples.datatable.basic;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.basic.*;

@UiView
public class BasicDataTableViewImpl extends SampleViewImpl {
    @Inject
    public BasicDataTableViewImpl() {
        register(DemoSample.of("datatable-basic", BasicDataTableSample.class, LazyProvider.of(BasicDataTableSample::create)));
    }
}