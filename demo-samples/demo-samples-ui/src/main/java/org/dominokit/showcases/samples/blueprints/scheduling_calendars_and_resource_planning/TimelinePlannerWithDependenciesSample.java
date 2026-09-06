package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class TimelinePlannerWithDependenciesSample {

  private TimelinePlannerWithDependenciesSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Timeline planner with dependencies",
        "Layout: Work items are represented on a time axis with dependency connectors and milestone markers. Interaction: Users adjust dates, create dependencies, assign owners, and identify critical-path changes. Variants: Project plan, release plan, or implementation plan.",
        BlueprintSampleKind.SCHEDULING,
        "Work items are represented on a time axis with dependency connectors and milestone markers.", "Users adjust dates, create dependencies, assign owners, and identify critical-path changes.");
  }
}
