package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class KpiDashboardWithResponsiveCardGridSample {

  private KpiDashboardWithResponsiveCardGridSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "KPI dashboard with responsive card grid",
        "Layout: Page header and global filters lead into metric cards, small charts, and supporting tables. Interaction: Users change the time range, drill into a metric, reorder cards, or open a detailed report. Variants: Fixed executive layout, user-customizable grid, or mobile stacked cards.",
        BlueprintSampleKind.DASHBOARD,
        "Page header and global filters lead into metric cards, small charts, and supporting tables.", "Users change the time range, drill into a metric, reorder cards, or open a detailed report.");
  }
}
