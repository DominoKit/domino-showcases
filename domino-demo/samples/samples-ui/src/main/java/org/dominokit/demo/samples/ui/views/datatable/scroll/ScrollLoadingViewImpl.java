package org.dominokit.demo.samples.ui.views.datatable.scroll;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.scroll.ScrollLoadingView;
    import org.dominokit.showcases.samples.datatable.scroll.ScrollLoadingSample;

    @UiView
    public class ScrollLoadingViewImpl extends SamplePageView<ScrollLoadingView.ScrollLoadingUiHandlers>
        implements ScrollLoadingView {

      @Inject
      public ScrollLoadingViewImpl() {
        super("Scroll Loading", "Scroll Loading examples rendered from the shared demo-samples module.");
addSample(ScrollLoadingSample.class, ScrollLoadingSample::create);
        initPage();
      }
    }
