package org.dominokit.demo.samples.ui.views.helpers;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.helpers.HelpersView;
        import org.dominokit.showcases.samples.helpers.HelpersHeightSample;
import org.dominokit.showcases.samples.helpers.HelpersWidthSample;
import org.dominokit.showcases.samples.helpers.HelpersMarginSample;
import org.dominokit.showcases.samples.helpers.HelpersPaddingSample;

        @UiView
        public class HelpersViewImpl extends SamplePageView<HelpersView.HelpersUiHandlers>
            implements HelpersView {

          @Inject
          public HelpersViewImpl() {
            super("Helpers", "Helpers examples rendered from the shared demo-samples module.");
    addSample(HelpersHeightSample.class, HelpersHeightSample::create);
    addSample(HelpersWidthSample.class, HelpersWidthSample::create);
    addSample(HelpersMarginSample.class, HelpersMarginSample::create);
    addSample(HelpersPaddingSample.class, HelpersPaddingSample::create);
            initPage();
          }
        }
