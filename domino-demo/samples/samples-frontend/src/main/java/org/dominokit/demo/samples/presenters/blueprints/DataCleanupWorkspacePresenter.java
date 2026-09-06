package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.DataCleanupWorkspaceView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DataCleanupWorkspacePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DataCleanupWorkspacePresenter extends ChildPresenter<ShellPresenter, DataCleanupWorkspaceView>
    implements DataCleanupWorkspaceView.DataCleanupWorkspaceUiHandlers {

  public static final String ROUTE = "blueprints/import-export-migration-and-bulk-operations/data-cleanup-workspace";
}
