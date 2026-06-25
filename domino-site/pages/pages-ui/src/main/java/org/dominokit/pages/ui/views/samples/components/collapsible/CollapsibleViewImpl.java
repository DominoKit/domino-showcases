package org.dominokit.pages.ui.views.samples.components.collapsible;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.collapsible.*;

@UiView
public class CollapsibleViewImpl extends SampleViewImpl {
    @Inject
    public CollapsibleViewImpl() {
        register(DemoSample.of("collapse-strategy", CollapsibleStrategySample.class, LazyProvider.of(CollapsibleStrategySample::create)));
        register(DemoSample.of("collapse-accordion", AccordionSample.class, LazyProvider.of(AccordionSample::create)));
        register(DemoSample.of("collapse-accordion-multi-open", MultiOpenAccordionSample.class, LazyProvider.of(MultiOpenAccordionSample::create)));
    }
}