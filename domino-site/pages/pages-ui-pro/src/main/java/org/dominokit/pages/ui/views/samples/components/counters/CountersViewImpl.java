package org.dominokit.pages.ui.views.samples.components.counters;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.counters.*;

@UiView
public class CountersViewImpl extends SampleViewImpl {
    @Inject
    public CountersViewImpl() {
        register(DemoSample.of("counters-simple", SimpleCountersSample.class, LazyProvider.of(SimpleCountersSample::create)));
        register(DemoSample.of("counters-auto", AutoCountersSample.class, LazyProvider.of(AutoCountersSample::create)));
        register(DemoSample.of("counters-date", DateCountDownSample.class, LazyProvider.of(DateCountDownSample::create)));
    }
}