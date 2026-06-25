package org.dominokit.pages.ui.views.samples.components.loaders;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.loaders.*;

@UiView
public class LoadersViewImpl extends SampleViewImpl {
    @Inject
    public LoadersViewImpl() {
        register(DemoSample.of("loaders-basic", LoadersBasicSample.class, LazyProvider.of(LoadersBasicSample::create)));
    }
}