package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.ServiceHealthDashboardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ServiceHealthDashboardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ServiceHealthDashboardPresenter extends ChildPresenter<ShellPresenter, ServiceHealthDashboardView>
    implements ServiceHealthDashboardView.ServiceHealthDashboardUiHandlers {

  public static final String ROUTE = "blueprints/operations-monitoring-and-exception-handling/service-health-dashboard";
}
