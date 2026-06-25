package org.dominokit.pages.ui.views.samples.components.preloaders;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.preloaders.*;

@UiView
public class PreLoadersViewImpl extends SampleViewImpl {
    @Inject
    public PreLoadersViewImpl() {
        register(DemoSample.of("pre-loader-basic", BasicPreLoadersSample.class, LazyProvider.of(BasicPreLoadersSample::create)));
        register(DemoSample.of("pre-loader-colored", ColoredPreLoadersSample.class, LazyProvider.of(ColoredPreLoadersSample::create)));
    }
}