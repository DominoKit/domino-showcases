package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DashboardsAndOverviewScreensView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/dashboards-and-overview-screens")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DashboardsAndOverviewScreensPresenter extends ChildPresenter<ShellPresenter, DashboardsAndOverviewScreensView>
    implements DashboardsAndOverviewScreensView.DashboardsAndOverviewScreensUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens";
}
