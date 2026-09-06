package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.BatchOperationMonitorView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.BatchOperationMonitorSample;

@UiView
public class BatchOperationMonitorViewImpl extends SamplePageView<BatchOperationMonitorView.BatchOperationMonitorUiHandlers>
    implements BatchOperationMonitorView {

  @Inject
  public BatchOperationMonitorViewImpl() {
    super("Batch operation monitor", "Layout: A submitted bulk operation has progress, counts, failures, logs, and cancellation controls. Interaction: Users monitor, pause/cancel, retry failures, download results, and open affected records. Variants: Bulk email, recalculation, reindexing, or mass status update.");
    addSample("Batch operation monitor", "Layout: A submitted bulk operation has progress, counts, failures, logs, and cancellation controls. Interaction: Users monitor, pause/cancel, retry failures, download results, and open affected records. Variants: Bulk email, recalculation, reindexing, or mass status update.", BatchOperationMonitorSample.class, BatchOperationMonitorSample::create);
    initPage();
  }
}
