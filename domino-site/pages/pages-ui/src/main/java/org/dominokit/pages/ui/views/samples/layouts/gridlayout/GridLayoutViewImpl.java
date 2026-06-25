package org.dominokit.pages.ui.views.samples.layouts.gridlayout;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.layouts.gridlayout.*;

@UiView
public class GridLayoutViewImpl extends SampleViewImpl {
    @Inject
    public GridLayoutViewImpl() {
        register(DemoSample.of("grid-layout", GridLayoutSample.class, LazyProvider.of(GridLayoutSample::create)));
    }
}