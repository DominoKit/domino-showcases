package org.dominokit.demo.samples.ui.views.layouts.gridlayout;

    import javax.inject.Inject;
    import org.dominokit.brix.annotations.UiView;
    import org.dominokit.demo.samples.ui.views.SamplePageView;
    import org.dominokit.demo.samples.views.layouts.gridlayout.GridLayoutView;
    import org.dominokit.showcases.samples.layouts.gridlayout.GridLayoutSample;

    @UiView
    public class GridLayoutViewImpl extends SamplePageView<GridLayoutView.GridLayoutUiHandlers>
        implements GridLayoutView {

      @Inject
      public GridLayoutViewImpl() {
        super("Grid Layout", "Grid Layout examples rendered from the shared demo-samples module.");
addSample(GridLayoutSample.class, GridLayoutSample::create);
        initPage();
      }
    }
