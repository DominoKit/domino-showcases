package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DashboardWithSavedViewsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DashboardWithSavedViewsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DashboardWithSavedViewsPresenter extends ChildPresenter<ShellPresenter, DashboardWithSavedViewsView>
    implements DashboardWithSavedViewsView.DashboardWithSavedViewsUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/dashboard-with-saved-views";
}
