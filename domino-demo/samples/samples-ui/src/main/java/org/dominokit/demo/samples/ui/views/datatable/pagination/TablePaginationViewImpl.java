package org.dominokit.demo.samples.ui.views.datatable.pagination;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.datatable.pagination.TablePaginationView;
        import org.dominokit.showcases.samples.datatable.pagination.SimplePaginationSample;
import org.dominokit.showcases.samples.datatable.pagination.ScrollingPaginationSample;
import org.dominokit.showcases.samples.datatable.pagination.AdvancedPaginationSample;

        @UiView
        public class TablePaginationViewImpl extends SamplePageView<TablePaginationView.TablePaginationUiHandlers>
            implements TablePaginationView {

          @Inject
          public TablePaginationViewImpl() {
            super("Pagination Plugin", "Pagination Plugin examples rendered from the shared demo-samples module.");
    addSample(SimplePaginationSample.class, SimplePaginationSample::create);
    addSample(ScrollingPaginationSample.class, ScrollingPaginationSample::create);
    addSample(AdvancedPaginationSample.class, AdvancedPaginationSample::create);
            initPage();
          }
        }
