package org.dominokit.demo.samples.ui.views.layouts.applayout;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.layouts.applayout.AppLayoutView;
    import org.dominokit.showcases.samples.layouts.applayout.AppLayoutSample;

    @UiView
    public class AppLayoutViewImpl extends SamplePageView<AppLayoutView.AppLayoutUiHandlers>
        implements AppLayoutView {

      @Inject
      public AppLayoutViewImpl() {
        super("App Layout", "App Layout examples rendered from the shared demo-samples module.");
addSample(AppLayoutSample.class, AppLayoutSample::create);
        initPage();
      }
    }
