package org.dominokit.demo.samples.ui.views.components.collapsible;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.collapsible.CollapsibleView;
        import org.dominokit.showcases.samples.components.collapsible.CollapsibleStrategySample;
import org.dominokit.showcases.samples.components.collapsible.AccordionSample;
import org.dominokit.showcases.samples.components.collapsible.MultiOpenAccordionSample;

        @UiView
        public class CollapsibleViewImpl extends SamplePageView<CollapsibleView.CollapsibleUiHandlers>
            implements CollapsibleView {

          @Inject
          public CollapsibleViewImpl() {
            super("Collapse", "Collapse examples rendered from the shared demo-samples module.");
    addSample(CollapsibleStrategySample.class, CollapsibleStrategySample::create);
    addSample(AccordionSample.class, AccordionSample::create);
    addSample(MultiOpenAccordionSample.class, MultiOpenAccordionSample::create);
            initPage();
          }
        }
