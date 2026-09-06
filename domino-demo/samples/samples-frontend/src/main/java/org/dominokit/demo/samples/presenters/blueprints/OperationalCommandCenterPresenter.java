package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.OperationalCommandCenterView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(OperationalCommandCenterPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class OperationalCommandCenterPresenter extends ChildPresenter<ShellPresenter, OperationalCommandCenterView>
    implements OperationalCommandCenterView.OperationalCommandCenterUiHandlers {

  public static final String ROUTE = "blueprints/dashboards-and-overview-screens/operational-command-center";
}
