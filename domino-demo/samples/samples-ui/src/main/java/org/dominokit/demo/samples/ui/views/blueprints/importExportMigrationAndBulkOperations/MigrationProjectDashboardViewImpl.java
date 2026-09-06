package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.MigrationProjectDashboardView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.MigrationProjectDashboardSample;

@UiView
public class MigrationProjectDashboardViewImpl extends SamplePageView<MigrationProjectDashboardView.MigrationProjectDashboardUiHandlers>
    implements MigrationProjectDashboardView {

  @Inject
  public MigrationProjectDashboardViewImpl() {
    super("Migration project dashboard", "Layout: Migration phases, source/target summaries, validation counts, blockers, and run history. Interaction: Users configure mappings, run dry-runs, resolve issues, execute phases, and rollback where supported. Variants: Tenant migration, system migration, or data-version migration.");
    addSample("Migration project dashboard", "Layout: Migration phases, source/target summaries, validation counts, blockers, and run history. Interaction: Users configure mappings, run dry-runs, resolve issues, execute phases, and rollback where supported. Variants: Tenant migration, system migration, or data-version migration.", MigrationProjectDashboardSample.class, MigrationProjectDashboardSample::create);
    initPage();
  }
}
