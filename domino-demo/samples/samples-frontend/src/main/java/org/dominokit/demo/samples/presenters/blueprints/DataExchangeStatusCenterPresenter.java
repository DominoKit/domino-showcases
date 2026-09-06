package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.DataExchangeStatusCenterView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DataExchangeStatusCenterPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DataExchangeStatusCenterPresenter extends ChildPresenter<ShellPresenter, DataExchangeStatusCenterView>
    implements DataExchangeStatusCenterView.DataExchangeStatusCenterUiHandlers {

  public static final String ROUTE = "blueprints/import-export-migration-and-bulk-operations/data-exchange-status-center";
}
