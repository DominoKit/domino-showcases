package org.dominokit.demo.samples.ui.views.components.breadcrumbs;

        import javax.inject.Inject;
        import org.dominokit.brix.annotations.UiView;
        import org.dominokit.demo.samples.ui.views.SamplePageView;
        import org.dominokit.demo.samples.views.components.breadcrumbs.BreadcrumbsView;
        import org.dominokit.showcases.samples.components.breadcrumbs.BreadcrumbsBasicSample;
import org.dominokit.showcases.samples.components.breadcrumbs.BreadcrumbsBackgroundSample;
import org.dominokit.showcases.samples.components.breadcrumbs.BreadcrumbsAlignmentSample;

        @UiView
        public class BreadcrumbsViewImpl extends SamplePageView<BreadcrumbsView.BreadcrumbsUiHandlers>
            implements BreadcrumbsView {

          @Inject
          public BreadcrumbsViewImpl() {
            super("Breadcrumbs", "Breadcrumbs examples rendered from the shared demo-samples module.");
    addSample(BreadcrumbsBasicSample.class, BreadcrumbsBasicSample::create);
    addSample(BreadcrumbsBackgroundSample.class, BreadcrumbsBackgroundSample::create);
    addSample(BreadcrumbsAlignmentSample.class, BreadcrumbsAlignmentSample::create);
            initPage();
          }
        }
