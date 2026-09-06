package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class BatchOperationMonitorSample {

  private BatchOperationMonitorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Batch operation monitor",
        "Layout: A submitted bulk operation has progress, counts, failures, logs, and cancellation controls. Interaction: Users monitor, pause/cancel, retry failures, download results, and open affected records. Variants: Bulk email, recalculation, reindexing, or mass status update.",
        BlueprintSampleKind.BULK,
        "A submitted bulk operation has progress, counts, failures, logs, and cancellation controls.", "Users monitor, pause/cancel, retry failures, download results, and open affected records.");
  }
}
