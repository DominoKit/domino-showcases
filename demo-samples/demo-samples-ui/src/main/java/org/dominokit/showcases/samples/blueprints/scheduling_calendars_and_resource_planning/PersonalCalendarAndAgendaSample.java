package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class PersonalCalendarAndAgendaSample {

  private PersonalCalendarAndAgendaSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Personal calendar and agenda",
        "Layout: Calendar grid or agenda list with mini-calendar, filters, and event detail. Interaction: Users create, move, resize, edit, cancel, and respond to events. Variants: Day/week/month, agenda-first, or compact mobile calendar.",
        BlueprintSampleKind.SCHEDULING,
        "Calendar grid or agenda list with mini-calendar, filters, and event detail.", "Users create, move, resize, edit, cancel, and respond to events.");
  }
}
