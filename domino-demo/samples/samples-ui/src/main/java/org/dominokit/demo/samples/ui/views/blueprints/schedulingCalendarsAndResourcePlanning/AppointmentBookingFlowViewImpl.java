package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.AppointmentBookingFlowView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.AppointmentBookingFlowSample;

@UiView
public class AppointmentBookingFlowViewImpl extends BlueprintSamplePageView<AppointmentBookingFlowView.AppointmentBookingFlowUiHandlers>
    implements AppointmentBookingFlowView {

  @Inject
  public AppointmentBookingFlowViewImpl() {
    super("Appointment booking flow", "Layout: Service/resource selection, availability picker, customer details, and confirmation summary form a guided flow. Interaction: Users choose a slot, enter details, confirm, reschedule, or cancel. Variants: Public booking, staff booking, or assisted booking.");
    addSample("Appointment booking flow", "Layout: Service/resource selection, availability picker, customer details, and confirmation summary form a guided flow. Interaction: Users choose a slot, enter details, confirm, reschedule, or cancel. Variants: Public booking, staff booking, or assisted booking.", AppointmentBookingFlowSample.class, AppointmentBookingFlowSample::create);
    initPage();
  }
}
