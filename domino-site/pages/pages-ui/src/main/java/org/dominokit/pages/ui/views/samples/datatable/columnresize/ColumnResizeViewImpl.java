package org.dominokit.pages.ui.views.samples.datatable.columnresize;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.columnresize.*;

@UiView
public class ColumnResizeViewImpl extends SampleViewImpl {
    @Inject
    public ColumnResizeViewImpl() {
        register(DemoSample.of("datatable-column-resize", ColumnResizeSample.class, LazyProvider.of(ColumnResizeSample::create)));
    }
}