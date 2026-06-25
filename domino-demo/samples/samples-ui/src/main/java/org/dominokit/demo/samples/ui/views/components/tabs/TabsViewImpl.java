package org.dominokit.demo.samples.ui.views.components.tabs;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.tabs.TabsView;
        import org.dominokit.showcases.samples.components.tabs.BasicTabsSample;
import org.dominokit.showcases.samples.components.tabs.TabsAlignmentSample;
import org.dominokit.showcases.samples.components.tabs.ClosableTabsSample;
import org.dominokit.showcases.samples.components.tabs.ColoredTabsSample;
import org.dominokit.showcases.samples.components.tabs.TabsContentSample;
import org.dominokit.showcases.samples.components.tabs.TabsAnimationSample;
import org.dominokit.showcases.samples.components.tabs.VerticalTabsSample;

        @UiView
        public class TabsViewImpl extends SamplePageView<TabsView.TabsUiHandlers>
            implements TabsView {

          @Inject
          public TabsViewImpl() {
            super("Tabs", "Tabs examples rendered from the shared demo-samples module.");
    addSample(BasicTabsSample.class, BasicTabsSample::create);
    addSample(TabsAlignmentSample.class, TabsAlignmentSample::create);
    addSample(ClosableTabsSample.class, ClosableTabsSample::create);
    addSample(ColoredTabsSample.class, ColoredTabsSample::create);
    addSample(TabsContentSample.class, TabsContentSample::create);
    addSample(TabsAnimationSample.class, TabsAnimationSample::create);
    addSample(VerticalTabsSample.class, VerticalTabsSample::create);
            initPage();
          }
        }
