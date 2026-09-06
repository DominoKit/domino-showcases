package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.BatchOperationMonitorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(BatchOperationMonitorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class BatchOperationMonitorPresenter extends ChildPresenter<ShellPresenter, BatchOperationMonitorView>
    implements BatchOperationMonitorView.BatchOperationMonitorUiHandlers {

  public static final String ROUTE = "blueprints/import-export-migration-and-bulk-operations/batch-operation-monitor";
}
