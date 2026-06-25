package org.dominokit.demo.samples.ui.views.layouts.grids;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.layouts.grids.ResponsiveGridsView;
        import org.dominokit.showcases.samples.layouts.grids.Grid12ColumnsSample;
import org.dominokit.showcases.samples.layouts.grids.Grid16ColumnsSample;
import org.dominokit.showcases.samples.layouts.grids.Grid18ColumnsSample;
import org.dominokit.showcases.samples.layouts.grids.Grid24ColumnsSample;
import org.dominokit.showcases.samples.layouts.grids.Grid32ColumnsSample;

        @UiView
        public class ResponsiveGridsViewImpl extends SamplePageView<ResponsiveGridsView.ResponsiveGridsUiHandlers>
            implements ResponsiveGridsView {

          @Inject
          public ResponsiveGridsViewImpl() {
            super("Grids", "Grids examples rendered from the shared demo-samples module.");
    addSample(Grid12ColumnsSample.class, Grid12ColumnsSample::create);
    addSample(Grid16ColumnsSample.class, Grid16ColumnsSample::create);
    addSample(Grid18ColumnsSample.class, Grid18ColumnsSample::create);
    addSample(Grid24ColumnsSample.class, Grid24ColumnsSample::create);
    addSample(Grid32ColumnsSample.class, Grid32ColumnsSample::create);
            initPage();
          }
        }
