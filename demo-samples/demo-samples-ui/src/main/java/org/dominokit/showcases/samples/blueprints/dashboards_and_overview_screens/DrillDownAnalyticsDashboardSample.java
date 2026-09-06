package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DrillDownAnalyticsDashboardSample {

  private DrillDownAnalyticsDashboardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Drill-down analytics dashboard",
        "Layout: High-level visualization occupies the upper region with supporting breakdowns beneath it. Interaction: Selecting a data point applies a filter to lower-level charts or opens a filtered record list. Variants: Click-through, brush-and-zoom, or breadcrumb-based drill path.",
        BlueprintSampleKind.DASHBOARD,
        "High-level visualization occupies the upper region with supporting breakdowns beneath it.", "Selecting a data point applies a filter to lower-level charts or opens a filtered record list.");
  }
}
