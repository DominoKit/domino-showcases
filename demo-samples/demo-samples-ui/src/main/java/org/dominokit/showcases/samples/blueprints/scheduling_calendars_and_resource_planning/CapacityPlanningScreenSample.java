package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class CapacityPlanningScreenSample {

  private CapacityPlanningScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Capacity planning screen",
        "Layout: Demand, available capacity, allocation, and forecast are shown in aligned charts or tables. Interaction: Users change assumptions, allocate capacity, compare scenarios, and publish a plan. Variants: People, machines, budget, or support capacity.",
        BlueprintSampleKind.SCHEDULING,
        "Demand, available capacity, allocation, and forecast are shown in aligned charts or tables.", "Users change assumptions, allocate capacity, compare scenarios, and publish a plan.");
  }
}
