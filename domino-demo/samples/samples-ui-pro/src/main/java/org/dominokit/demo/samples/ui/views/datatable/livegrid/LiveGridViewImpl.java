package org.dominokit.demo.samples.ui.views.datatable.livegrid;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.datatable.livegrid.LiveGridView;
    import org.dominokit.showcases.samples.datatable.livegrid.LiveGridSample;

    @UiView
    public class LiveGridViewImpl extends SamplePageView<LiveGridView.LiveGridUiHandlers>
        implements LiveGridView {

      @Inject
      public LiveGridViewImpl() {
        super("Live Grid", "Live Grid examples rendered from the shared demo-samples module.");
addSample(LiveGridSample.class, LiveGridSample::create);
        initPage();
      }
    }
