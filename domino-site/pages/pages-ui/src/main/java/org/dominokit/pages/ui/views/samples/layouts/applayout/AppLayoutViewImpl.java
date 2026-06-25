package org.dominokit.pages.ui.views.samples.layouts.applayout;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.layouts.applayout.*;

@UiView
public class AppLayoutViewImpl extends SampleViewImpl {
    @Inject
    public AppLayoutViewImpl() {
        register(DemoSample.of("app-layout", AppLayoutSample.class, LazyProvider.of(AppLayoutSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content.setCssProperty("max-height", "700px"))
                            .withDemoSample((parent, sample) -> {
                                LazyProvider<AppLayoutSample> component = sample.getComponent();
                                AppLayoutSample appLayoutSample = component.get();
                                appLayoutSample.setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
    }
}