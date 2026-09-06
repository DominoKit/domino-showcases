package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.MigrationProjectDashboardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MigrationProjectDashboardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MigrationProjectDashboardPresenter extends ChildPresenter<ShellPresenter, MigrationProjectDashboardView>
    implements MigrationProjectDashboardView.MigrationProjectDashboardUiHandlers {

  public static final String ROUTE = "blueprints/import-export-migration-and-bulk-operations/migration-project-dashboard";
}
