package org.dominokit.pages.ui.views.samples.datatable.marker;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.marker.*;

@UiView
public class TableRowMarkerViewImpl extends SampleViewImpl {
    @Inject
    public TableRowMarkerViewImpl() {
        register(DemoSample.of("datatable-marker", TableRowMarkerSample.class, LazyProvider.of(TableRowMarkerSample::create)));
    }
}