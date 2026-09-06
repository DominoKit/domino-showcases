package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.RoleBasedHomeDashboardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RoleBasedHomeDashboardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RoleBasedHomeDashboardPresenter extends ChildPresenter<ShellPresenter, RoleBasedHomeDashboardView>
    implements RoleBasedHomeDashboardView.RoleBasedHomeDashboardUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/role-based-home-dashboard";
}
