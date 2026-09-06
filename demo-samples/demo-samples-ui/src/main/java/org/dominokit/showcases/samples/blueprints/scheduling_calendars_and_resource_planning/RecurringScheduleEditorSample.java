package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RecurringScheduleEditorSample {

  private RecurringScheduleEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Recurring schedule editor",
        "Layout: Schedule details are paired with recurrence rules, exceptions, preview dates, and timezone controls. Interaction: Users define recurrence, add exceptions, preview occurrences, and save the schedule. Variants: Calendar recurrence, batch job schedule, or notification schedule.",
        BlueprintSampleKind.SCHEDULING,
        "Schedule details are paired with recurrence rules, exceptions, preview dates, and timezone controls.", "Users define recurrence, add exceptions, preview occurrences, and save the schedule.");
  }
}
