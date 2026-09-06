package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.PersonalCalendarAndAgendaView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(PersonalCalendarAndAgendaPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class PersonalCalendarAndAgendaPresenter extends ChildPresenter<ShellPresenter, PersonalCalendarAndAgendaView>
    implements PersonalCalendarAndAgendaView.PersonalCalendarAndAgendaUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/personal-calendar-and-agenda";
}
