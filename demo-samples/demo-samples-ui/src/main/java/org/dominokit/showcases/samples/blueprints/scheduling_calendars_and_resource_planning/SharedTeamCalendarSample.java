package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SharedTeamCalendarSample {

  private SharedTeamCalendarSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Shared team calendar",
        "Layout: Multiple calendars or resource lanes are displayed with a shared toolbar. Interaction: Users toggle calendars, schedule events, resolve overlaps, and inspect availability. Variants: Team members, rooms, equipment, or service territories.",
        BlueprintSampleKind.SCHEDULING,
        "Multiple calendars or resource lanes are displayed with a shared toolbar.", "Users toggle calendars, schedule events, resolve overlaps, and inspect availability.");
  }
}
