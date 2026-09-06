package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.ImportValidationAndCorrectionQueueView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ImportValidationAndCorrectionQueuePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ImportValidationAndCorrectionQueuePresenter extends ChildPresenter<ShellPresenter, ImportValidationAndCorrectionQueueView>
    implements ImportValidationAndCorrectionQueueView.ImportValidationAndCorrectionQueueUiHandlers {

  public static final String ROUTE = "blueprints/import-export-migration-and-bulk-operations/import-validation-and-correction-queue";
}
