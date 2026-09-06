package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.CapacityPlanningScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(CapacityPlanningScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class CapacityPlanningScreenPresenter extends ChildPresenter<ShellPresenter, CapacityPlanningScreenView>
    implements CapacityPlanningScreenView.CapacityPlanningScreenUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/capacity-planning-screen";
}
