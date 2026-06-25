package org.dominokit.pages.ui.views.samples.components.breadcrumbs;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.pages.ui.views.DemoSample;
import org.dominokit.pages.ui.views.LazyProvider;
import org.dominokit.pages.ui.views.SampleViewImpl;
import org.dominokit.showcases.samples.components.breadcrumbs.*;

@UiView
public class BreadcrumbsViewImpl extends SampleViewImpl {
    @Inject
    public BreadcrumbsViewImpl() {
        register(DemoSample.of("breadcrumbs-basic", BreadcrumbsBasicSample.class, LazyProvider.of(BreadcrumbsBasicSample::create)));
        register(DemoSample.of("breadcrumbs-background", BreadcrumbsBackgroundSample.class, LazyProvider.of(BreadcrumbsBackgroundSample::create)));
        register(DemoSample.of("breadcrumbs-alignment", BreadcrumbsAlignmentSample.class, LazyProvider.of(BreadcrumbsAlignmentSample::create)));
    }
}