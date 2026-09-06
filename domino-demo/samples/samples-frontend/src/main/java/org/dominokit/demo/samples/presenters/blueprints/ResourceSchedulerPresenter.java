package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.ResourceSchedulerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ResourceSchedulerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ResourceSchedulerPresenter extends ChildPresenter<ShellPresenter, ResourceSchedulerView>
    implements ResourceSchedulerView.ResourceSchedulerUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/resource-scheduler";
}
