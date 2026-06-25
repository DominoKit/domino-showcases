package org.dominokit.pages.ui.views.samples.datatable.menu;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.menu.*;

@UiView
public class RowMenuViewImpl extends SampleViewImpl {
    @Inject
    public RowMenuViewImpl() {
        register(DemoSample.of("datatable-row-menu", RowMenuSample.class, LazyProvider.of(RowMenuSample::create)));
    }
}