package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ShiftPlanningBoardSample {

  private ShiftPlanningBoardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Shift planning board",
        "Layout: Staff rows and time periods contain shift blocks, coverage indicators, and unfilled slots. Interaction: Planners assign, drag, swap, copy, publish, and resolve coverage warnings. Variants: Weekly roster, monthly roster, or location-based roster.",
        BlueprintSampleKind.SCHEDULING,
        "Staff rows and time periods contain shift blocks, coverage indicators, and unfilled slots.", "Planners assign, drag, swap, copy, publish, and resolve coverage warnings.");
  }
}
