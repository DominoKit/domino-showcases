package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.TransactionReconciliationScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TransactionReconciliationScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TransactionReconciliationScreenPresenter extends ChildPresenter<ShellPresenter, TransactionReconciliationScreenView>
    implements TransactionReconciliationScreenView.TransactionReconciliationScreenUiHandlers {

  public static final String ROUTE = "blueprints/operations-monitoring-and-exception-handling/transaction-reconciliation-screen";
}
