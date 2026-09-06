package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.TimelinePlannerWithDependenciesView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TimelinePlannerWithDependenciesPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TimelinePlannerWithDependenciesPresenter extends ChildPresenter<ShellPresenter, TimelinePlannerWithDependenciesView>
    implements TimelinePlannerWithDependenciesView.TimelinePlannerWithDependenciesUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/timeline-planner-with-dependencies";
}
