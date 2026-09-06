package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.SharedTeamCalendarView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SharedTeamCalendarPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SharedTeamCalendarPresenter extends ChildPresenter<ShellPresenter, SharedTeamCalendarView>
    implements SharedTeamCalendarView.SharedTeamCalendarUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/shared-team-calendar";
}
