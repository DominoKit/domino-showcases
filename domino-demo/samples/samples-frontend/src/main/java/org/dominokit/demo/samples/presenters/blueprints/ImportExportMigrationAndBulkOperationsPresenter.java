package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.ImportExportMigrationAndBulkOperationsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/import-export-migration-and-bulk-operations")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ImportExportMigrationAndBulkOperationsPresenter extends ChildPresenter<ShellPresenter, ImportExportMigrationAndBulkOperationsView>
    implements ImportExportMigrationAndBulkOperationsView.ImportExportMigrationAndBulkOperationsUiHandlers {

  public static final String ROUTE = "blueprints/import-export-migration-and-bulk-operations";
}
