package org.dominokit.pages.ui.views.samples.datatable.top;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.top.*;

@UiView
public class TableTopPanelViewImpl extends SampleViewImpl {
    @Inject
    public TableTopPanelViewImpl() {
        register(DemoSample.of("datatable-top-panel", TableTopPanelSample.class, LazyProvider.of(TableTopPanelSample::create)));
    }
}