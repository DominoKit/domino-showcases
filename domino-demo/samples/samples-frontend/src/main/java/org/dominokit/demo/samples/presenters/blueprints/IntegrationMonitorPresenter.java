package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.IntegrationMonitorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(IntegrationMonitorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class IntegrationMonitorPresenter extends ChildPresenter<ShellPresenter, IntegrationMonitorView>
    implements IntegrationMonitorView.IntegrationMonitorUiHandlers {

  public static final String ROUTE = "blueprints/operations-monitoring-and-exception-handling/integration-monitor";
}
