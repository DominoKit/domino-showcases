package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.SchedulingCalendarsAndResourcePlanningView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/scheduling-calendars-and-resource-planning")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SchedulingCalendarsAndResourcePlanningPresenter extends ChildPresenter<ShellPresenter, SchedulingCalendarsAndResourcePlanningView>
    implements SchedulingCalendarsAndResourcePlanningView.SchedulingCalendarsAndResourcePlanningUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning";
}
