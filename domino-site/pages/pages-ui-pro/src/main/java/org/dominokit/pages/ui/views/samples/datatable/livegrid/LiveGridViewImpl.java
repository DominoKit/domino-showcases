package org.dominokit.pages.ui.views.samples.datatable.livegrid;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.livegrid.*;

@UiView
public class LiveGridViewImpl extends SampleViewImpl {
    @Inject
    public LiveGridViewImpl() {
        register(DemoSample.of("datatable-live-grid", LiveGridSample.class, LazyProvider.of(LiveGridSample::create)));
    }
}