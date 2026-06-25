package org.dominokit.pages.ui.views.samples.datatable.mix;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.datatable.mix.*;

@UiView
public class PluginMixViewImpl extends SampleViewImpl {
    @Inject
    public PluginMixViewImpl() {
        register(DemoSample.of("datatable-mix", PluginsMixSample.class, LazyProvider.of(PluginsMixSample::create)));
    }
}