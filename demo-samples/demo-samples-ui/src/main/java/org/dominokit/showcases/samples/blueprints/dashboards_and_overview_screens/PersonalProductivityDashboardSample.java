package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class PersonalProductivityDashboardSample {

  private PersonalProductivityDashboardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Personal productivity dashboard",
        "Layout: Today/next-up summary, tasks, calendar preview, notifications, and recently opened items. Interaction: Users complete, snooze, reschedule, or resume work directly from compact widgets. Variants: Focus mode, team mode, or calendar-first arrangement.",
        BlueprintSampleKind.DASHBOARD,
        "Today/next-up summary, tasks, calendar preview, notifications, and recently opened items.", "Users complete, snooze, reschedule, or resume work directly from compact widgets.");
  }
}
