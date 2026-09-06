package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ResourceSchedulerSample {

  private ResourceSchedulerSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Resource scheduler",
        "Layout: Resources form rows/columns while time forms the opposing axis; bookings appear as blocks. Interaction: Users create, move, resize, split, and cancel bookings while seeing conflicts. Variants: Gantt-like, timeline, calendar grid, or list-plus-calendar.",
        BlueprintSampleKind.SCHEDULING,
        "Resources form rows/columns while time forms the opposing axis; bookings appear as blocks.", "Users create, move, resize, split, and cancel bookings while seeing conflicts.");
  }
}
