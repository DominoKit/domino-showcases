package org.dominokit.demo.samples.ui.views.layouts.split;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.layouts.split.SplitPanelView;
        import org.dominokit.showcases.samples.layouts.split.SplitPanelHorizontal;
import org.dominokit.showcases.samples.layouts.split.SplitPanelVertical;
import org.dominokit.showcases.samples.layouts.split.SplitPanelMinMax;
import org.dominokit.showcases.samples.layouts.split.SplitPanelMultiple;
import org.dominokit.showcases.samples.layouts.split.SplitPanelCombined;

        @UiView
        public class SplitPanelViewImpl extends SamplePageView<SplitPanelView.SplitPanelUiHandlers>
            implements SplitPanelView {

          @Inject
          public SplitPanelViewImpl() {
            super("Split Panel", "Split Panel examples rendered from the shared demo-samples module.");
    addSample(SplitPanelHorizontal.class, SplitPanelHorizontal::create);
    addSample(SplitPanelVertical.class, SplitPanelVertical::create);
    addSample(SplitPanelMinMax.class, SplitPanelMinMax::create);
    addSample(SplitPanelMultiple.class, SplitPanelMultiple::create);
    addSample(SplitPanelCombined.class, SplitPanelCombined::create);
            initPage();
          }
        }
