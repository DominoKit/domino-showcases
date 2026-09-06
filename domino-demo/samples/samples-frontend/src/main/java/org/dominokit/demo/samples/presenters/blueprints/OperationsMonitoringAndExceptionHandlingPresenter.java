package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.OperationsMonitoringAndExceptionHandlingView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/operations-monitoring-and-exception-handling")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class OperationsMonitoringAndExceptionHandlingPresenter extends ChildPresenter<ShellPresenter, OperationsMonitoringAndExceptionHandlingView>
    implements OperationsMonitoringAndExceptionHandlingView.OperationsMonitoringAndExceptionHandlingUiHandlers {

  public static final String ROUTE = "blueprints/operations-monitoring-and-exception-handling";
}
