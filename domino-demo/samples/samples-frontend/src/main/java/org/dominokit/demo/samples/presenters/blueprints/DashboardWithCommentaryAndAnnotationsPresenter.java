package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DashboardWithCommentaryAndAnnotationsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DashboardWithCommentaryAndAnnotationsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DashboardWithCommentaryAndAnnotationsPresenter extends ChildPresenter<ShellPresenter, DashboardWithCommentaryAndAnnotationsView>
    implements DashboardWithCommentaryAndAnnotationsView.DashboardWithCommentaryAndAnnotationsUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/dashboard-with-commentary-and-annotations";
}
