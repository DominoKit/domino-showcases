package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class PortfolioOverviewDashboardSample {

  private PortfolioOverviewDashboardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Portfolio overview dashboard",
        "Layout: Summary metrics, portfolio health indicators, grouped cards, and a comparison table cover many projects, products, or accounts. Interaction: Users compare entities, filter by owner/status, and open a selected portfolio member. Variants: Grid, table-first, or quadrant visualization.",
        BlueprintSampleKind.DASHBOARD,
        "Summary metrics, portfolio health indicators, grouped cards, and a comparison table cover many projects, products, or accounts.", "Users compare entities, filter by owner/status, and open a selected portfolio member.");
  }
}
