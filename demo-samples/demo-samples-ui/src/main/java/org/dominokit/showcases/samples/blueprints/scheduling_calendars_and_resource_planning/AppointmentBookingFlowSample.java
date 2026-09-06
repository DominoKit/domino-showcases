package org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AppointmentBookingFlowSample {

  private AppointmentBookingFlowSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Appointment booking flow",
        "Layout: Service/resource selection, availability picker, customer details, and confirmation summary form a guided flow. Interaction: Users choose a slot, enter details, confirm, reschedule, or cancel. Variants: Public booking, staff booking, or assisted booking.",
        BlueprintSampleKind.SCHEDULING,
        "Service/resource selection, availability picker, customer details, and confirmation summary form a guided flow.", "Users choose a slot, enter details, confirm, reschedule, or cancel.");
  }
}
