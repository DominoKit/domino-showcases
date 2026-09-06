package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DrillDownAnalyticsDashboardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DrillDownAnalyticsDashboardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DrillDownAnalyticsDashboardPresenter extends ChildPresenter<ShellPresenter, DrillDownAnalyticsDashboardView>
    implements DrillDownAnalyticsDashboardView.DrillDownAnalyticsDashboardUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/drill-down-analytics-dashboard";
}
