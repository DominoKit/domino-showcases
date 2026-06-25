package org.dominokit.pages.ui.views.samples.components.waves;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.waves.*;

@UiView
public class WavesViewImpl extends SampleViewImpl {
    @Inject
    public WavesViewImpl() {
        register(DemoSample.of("waves-basic", WavesSample.class, LazyProvider.of(WavesSample::create)));
    }
}