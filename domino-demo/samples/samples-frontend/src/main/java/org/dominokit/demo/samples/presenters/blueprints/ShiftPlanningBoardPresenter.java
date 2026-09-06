package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.ShiftPlanningBoardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ShiftPlanningBoardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ShiftPlanningBoardPresenter extends ChildPresenter<ShellPresenter, ShiftPlanningBoardView>
    implements ShiftPlanningBoardView.ShiftPlanningBoardUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/shift-planning-board";
}
