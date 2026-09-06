package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.ImportExportMigrationAndBulkOperationsView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.ImportWizardWithMappingSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.ImportValidationAndCorrectionQueueSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.ExportBuilderSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.BulkEditReviewScreenSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.MigrationProjectDashboardSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.DataCleanupWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.BatchOperationMonitorSample;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.DataExchangeStatusCenterSample;

@UiView
public class ImportExportMigrationAndBulkOperationsViewImpl extends BrixView<HTMLDivElement, ImportExportMigrationAndBulkOperationsView.ImportExportMigrationAndBulkOperationsUiHandlers>
    implements ImportExportMigrationAndBulkOperationsView {

  private final DivElement root;

  @Inject
  public ImportExportMigrationAndBulkOperationsViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Import, export, migration, and bulk operations",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Import wizard with mapping",
                    "Layout: Upload step, column-mapping step, validation preview, and commit summary. Interaction: Users upload data, map source fields, resolve invalid rows, and start the import. Variants: CSV, spreadsheet, JSON, or copied tabular data.",
                    ImportWizardWithMappingSample.class,
                    ImportWizardWithMappingSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Import validation and correction queue",
                    "Layout: Valid rows and invalid rows are summarized with an error table and correction editor. Interaction: Users fix values inline, download errors, revalidate, and continue or cancel. Variants: Row-level correction, cell-level correction, or rules-assisted correction.",
                    ImportValidationAndCorrectionQueueSample.class,
                    ImportValidationAndCorrectionQueueSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Export builder",
                    "Layout: Dataset selection, columns, filters, format, and delivery options are arranged as a short flow or form. Interaction: Users configure, preview, generate, download, or schedule an export. Variants: Immediate download, queued export, or recurring export.",
                    ExportBuilderSample.class,
                    ExportBuilderSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Bulk edit review screen",
                    "Layout: Selected records, proposed field changes, validation warnings, and impact summary appear before commit. Interaction: Users edit a shared value, review per-record exceptions, confirm, and monitor completion. Variants: Synchronous update, background job, or approval-required bulk change.",
                    BulkEditReviewScreenSample.class,
                    BulkEditReviewScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Migration project dashboard",
                    "Layout: Migration phases, source/target summaries, validation counts, blockers, and run history. Interaction: Users configure mappings, run dry-runs, resolve issues, execute phases, and rollback where supported. Variants: Tenant migration, system migration, or data-version migration.",
                    MigrationProjectDashboardSample.class,
                    MigrationProjectDashboardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Data cleanup workspace",
                    "Layout: Duplicate/invalid candidates, matching rules, previewed merges, and action history are presented together. Interaction: Users review candidates, merge/suppress, apply rules, and undo where possible. Variants: Duplicate contacts, catalog cleanup, or master-data cleanup.",
                    DataCleanupWorkspaceSample.class,
                    DataCleanupWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Batch operation monitor",
                    "Layout: A submitted bulk operation has progress, counts, failures, logs, and cancellation controls. Interaction: Users monitor, pause/cancel, retry failures, download results, and open affected records. Variants: Bulk email, recalculation, reindexing, or mass status update.",
                    BatchOperationMonitorSample.class,
                    BatchOperationMonitorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Data exchange status center",
                    "Layout: Inbound/outbound exchanges are listed with direction, schedule, status, volume, and last successful run. Interaction: Users inspect an exchange, retry, download artifacts, and configure notifications. Variants: Partner exchange, regulatory submission, or scheduled feed.",
                    DataExchangeStatusCenterSample.class,
                    DataExchangeStatusCenterSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
