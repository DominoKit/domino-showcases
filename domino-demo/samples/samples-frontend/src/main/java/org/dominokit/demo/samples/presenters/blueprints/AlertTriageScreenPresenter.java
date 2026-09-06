package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.AlertTriageScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AlertTriageScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AlertTriageScreenPresenter extends ChildPresenter<ShellPresenter, AlertTriageScreenView>
    implements AlertTriageScreenView.AlertTriageScreenUiHandlers {

  public static final String ROUTE = "blueprints/operations-monitoring-and-exception-handling/alert-triage-screen";
}
