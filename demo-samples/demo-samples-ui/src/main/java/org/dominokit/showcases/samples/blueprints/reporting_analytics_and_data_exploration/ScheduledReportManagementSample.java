package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ScheduledReportManagementSample {

  private ScheduledReportManagementSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Scheduled report management",
        "Layout: Report list includes schedule, recipients, delivery status, and last-run information. Interaction: Users create, pause, edit, test, duplicate, and monitor scheduled deliveries. Variants: Email delivery, file drop, dashboard refresh, or webhook delivery.",
        BlueprintSampleKind.REPORT,
        "Report list includes schedule, recipients, delivery status, and last-run information.", "Users create, pause, edit, test, duplicate, and monitor scheduled deliveries.");
  }
}
