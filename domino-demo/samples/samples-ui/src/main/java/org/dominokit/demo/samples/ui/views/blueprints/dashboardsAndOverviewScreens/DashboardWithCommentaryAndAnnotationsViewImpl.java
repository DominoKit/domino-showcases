package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DashboardWithCommentaryAndAnnotationsView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.DashboardWithCommentaryAndAnnotationsSample;

@UiView
public class DashboardWithCommentaryAndAnnotationsViewImpl extends BlueprintSamplePageView<DashboardWithCommentaryAndAnnotationsView.DashboardWithCommentaryAndAnnotationsUiHandlers>
    implements DashboardWithCommentaryAndAnnotationsView {

  @Inject
  public DashboardWithCommentaryAndAnnotationsViewImpl() {
    super("Dashboard with commentary and annotations", "Layout: Charts and metrics are paired with an activity/commentary rail. Interaction: Users annotate a metric, mention colleagues, resolve comments, and preserve commentary with a reporting period. Variants: Threaded comments, pin-to-chart annotations, or review-cycle notes.");
    addSample("Dashboard with commentary and annotations", "Layout: Charts and metrics are paired with an activity/commentary rail. Interaction: Users annotate a metric, mention colleagues, resolve comments, and preserve commentary with a reporting period. Variants: Threaded comments, pin-to-chart annotations, or review-cycle notes.", DashboardWithCommentaryAndAnnotationsSample.class, DashboardWithCommentaryAndAnnotationsSample::create);
    initPage();
  }
}
