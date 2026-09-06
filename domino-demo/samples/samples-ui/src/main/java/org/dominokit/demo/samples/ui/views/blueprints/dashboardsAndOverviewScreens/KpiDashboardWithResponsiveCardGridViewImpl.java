package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.KpiDashboardWithResponsiveCardGridView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.KpiDashboardWithResponsiveCardGridSample;

@UiView
public class KpiDashboardWithResponsiveCardGridViewImpl extends BlueprintSamplePageView<KpiDashboardWithResponsiveCardGridView.KpiDashboardWithResponsiveCardGridUiHandlers>
    implements KpiDashboardWithResponsiveCardGridView {

  @Inject
  public KpiDashboardWithResponsiveCardGridViewImpl() {
    super("KPI dashboard with responsive card grid", "Layout: Page header and global filters lead into metric cards, small charts, and supporting tables. Interaction: Users change the time range, drill into a metric, reorder cards, or open a detailed report. Variants: Fixed executive layout, user-customizable grid, or mobile stacked cards.");
    addSample("KPI dashboard with responsive card grid", "Layout: Page header and global filters lead into metric cards, small charts, and supporting tables. Interaction: Users change the time range, drill into a metric, reorder cards, or open a detailed report. Variants: Fixed executive layout, user-customizable grid, or mobile stacked cards.", KpiDashboardWithResponsiveCardGridSample.class, KpiDashboardWithResponsiveCardGridSample::create);
    initPage();
  }
}
