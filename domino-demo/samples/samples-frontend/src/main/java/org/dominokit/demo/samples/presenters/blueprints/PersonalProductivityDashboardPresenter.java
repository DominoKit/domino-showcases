package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.PersonalProductivityDashboardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(PersonalProductivityDashboardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class PersonalProductivityDashboardPresenter extends ChildPresenter<ShellPresenter, PersonalProductivityDashboardView>
    implements PersonalProductivityDashboardView.PersonalProductivityDashboardUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/personal-productivity-dashboard";
}
