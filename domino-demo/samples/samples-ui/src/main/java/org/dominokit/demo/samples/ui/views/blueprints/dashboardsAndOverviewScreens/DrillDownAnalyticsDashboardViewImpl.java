package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DrillDownAnalyticsDashboardView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.DrillDownAnalyticsDashboardSample;

@UiView
public class DrillDownAnalyticsDashboardViewImpl extends BlueprintSamplePageView<DrillDownAnalyticsDashboardView.DrillDownAnalyticsDashboardUiHandlers>
    implements DrillDownAnalyticsDashboardView {

  @Inject
  public DrillDownAnalyticsDashboardViewImpl() {
    super("Drill-down analytics dashboard", "Layout: High-level visualization occupies the upper region with supporting breakdowns beneath it. Interaction: Selecting a data point applies a filter to lower-level charts or opens a filtered record list. Variants: Click-through, brush-and-zoom, or breadcrumb-based drill path.");
    addSample("Drill-down analytics dashboard", "Layout: High-level visualization occupies the upper region with supporting breakdowns beneath it. Interaction: Selecting a data point applies a filter to lower-level charts or opens a filtered record list. Variants: Click-through, brush-and-zoom, or breadcrumb-based drill path.", DrillDownAnalyticsDashboardSample.class, DrillDownAnalyticsDashboardSample::create);
    initPage();
  }
}
