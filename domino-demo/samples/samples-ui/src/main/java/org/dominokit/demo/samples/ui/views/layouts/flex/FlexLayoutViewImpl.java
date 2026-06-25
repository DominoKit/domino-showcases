package org.dominokit.demo.samples.ui.views.layouts.flex;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.layouts.flex.FlexLayoutView;
        import org.dominokit.showcases.samples.layouts.flex.FlexLayoutPlayground;
import org.dominokit.showcases.samples.layouts.flex.FlexItemPlayground;

        @UiView
        public class FlexLayoutViewImpl extends SamplePageView<FlexLayoutView.FlexLayoutUiHandlers>
            implements FlexLayoutView {

          @Inject
          public FlexLayoutViewImpl() {
            super("Flex Layout", "Flex Layout examples rendered from the shared demo-samples module.");
    addSample(FlexLayoutPlayground.class, FlexLayoutPlayground::create);
    addSample(FlexItemPlayground.class, FlexItemPlayground::create);
            initPage();
          }
        }
