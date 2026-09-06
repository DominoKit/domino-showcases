package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DashboardWithCommentaryAndAnnotationsSample {

  private DashboardWithCommentaryAndAnnotationsSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Dashboard with commentary and annotations",
        "Layout: Charts and metrics are paired with an activity/commentary rail. Interaction: Users annotate a metric, mention colleagues, resolve comments, and preserve commentary with a reporting period. Variants: Threaded comments, pin-to-chart annotations, or review-cycle notes.",
        BlueprintSampleKind.DASHBOARD,
        "Charts and metrics are paired with an activity/commentary rail.", "Users annotate a metric, mention colleagues, resolve comments, and preserve commentary with a reporting period.");
  }
}
