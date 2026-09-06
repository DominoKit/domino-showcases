package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.KpiDashboardWithResponsiveCardGridView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(KpiDashboardWithResponsiveCardGridPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class KpiDashboardWithResponsiveCardGridPresenter extends ChildPresenter<ShellPresenter, KpiDashboardWithResponsiveCardGridView>
    implements KpiDashboardWithResponsiveCardGridView.KpiDashboardWithResponsiveCardGridUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/kpi-dashboard-with-responsive-card-grid";
}
