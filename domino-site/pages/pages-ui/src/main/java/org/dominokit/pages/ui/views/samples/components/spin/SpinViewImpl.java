package org.dominokit.pages.ui.views.samples.components.spin;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.spin.*;

@UiView
public class SpinViewImpl extends SampleViewImpl {
    @Inject
    public SpinViewImpl() {
        register(DemoSample.of("spin-horizontal", HorizontalSpinSample.class, LazyProvider.of(HorizontalSpinSample::create)));
        register(DemoSample.of("spin-vertical", VerticalSpinSample.class, LazyProvider.of(VerticalSpinSample::create)));
    }
}