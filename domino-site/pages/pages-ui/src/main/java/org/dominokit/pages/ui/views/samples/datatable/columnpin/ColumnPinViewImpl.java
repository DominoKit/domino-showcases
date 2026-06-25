package org.dominokit.pages.ui.views.samples.datatable.columnpin;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.columnpin.*;

@UiView
public class ColumnPinViewImpl extends SampleViewImpl {
    @Inject
    public ColumnPinViewImpl() {
        register(DemoSample.of("datatable-column-pin", ColumnPinSample.class, LazyProvider.of(ColumnPinSample::create)));
    }
}