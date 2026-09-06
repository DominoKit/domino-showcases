package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.AppointmentBookingFlowView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AppointmentBookingFlowPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AppointmentBookingFlowPresenter extends ChildPresenter<ShellPresenter, AppointmentBookingFlowView>
    implements AppointmentBookingFlowView.AppointmentBookingFlowUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/appointment-booking-flow";
}
