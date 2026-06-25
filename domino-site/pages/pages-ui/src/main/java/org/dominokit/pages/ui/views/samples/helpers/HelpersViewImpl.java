package org.dominokit.pages.ui.views.samples.helpers;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.helpers.*;

@UiView
public class HelpersViewImpl extends SampleViewImpl {
    @Inject
    public HelpersViewImpl() {
        register(DemoSample.of("helpers-height", HelpersHeightSample.class, LazyProvider.of(HelpersHeightSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
        register(DemoSample.of("helpers-width", HelpersWidthSample.class, LazyProvider.of(HelpersWidthSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
        register(DemoSample.of("helpers-margin", HelpersMarginSample.class, LazyProvider.of(HelpersMarginSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
        register(DemoSample.of("helpers-padding", HelpersPaddingSample.class, LazyProvider.of(HelpersPaddingSample::create))
                .onRender(demoComponent -> {
                    demoComponent
                            .withSampleContainer((demoComponent1, content) -> content
                                    .setCssProperty("max-height", "700px")
                                    .setCssProperty("overflow", "auto")
                                    .setCssProperty("padding", "5px")
                            )
                            .withDemoSample((parent, sample) -> {
                                sample.getComponent()
                                        .get()
                                        .setCssProperty("max-height", "700px");
                            })
                    ;
                })
        );
    }
}