package org.dominokit.demo.samples.ui.views.components.pagination;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.pagination.PaginationView;
        import org.dominokit.showcases.samples.components.pagination.BasicPaginationSample;
import org.dominokit.showcases.samples.components.pagination.ScrollingPaginationSample;
import org.dominokit.showcases.samples.components.pagination.AdvancedPaginationSample;
import org.dominokit.showcases.samples.components.pagination.PagerPaginationSample;

        @UiView
        public class PaginationViewImpl extends SamplePageView<PaginationView.PaginationUiHandlers>
            implements PaginationView {

          @Inject
          public PaginationViewImpl() {
            super("Pagination", "Pagination examples rendered from the shared demo-samples module.");
    addSample(BasicPaginationSample.class, BasicPaginationSample::create);
    addSample(ScrollingPaginationSample.class, ScrollingPaginationSample::create);
    addSample(AdvancedPaginationSample.class, AdvancedPaginationSample::create);
    addSample(PagerPaginationSample.class, PagerPaginationSample::create);
            initPage();
          }
        }
