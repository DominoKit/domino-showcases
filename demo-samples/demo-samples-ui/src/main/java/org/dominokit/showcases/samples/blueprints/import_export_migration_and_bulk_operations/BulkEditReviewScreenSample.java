package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class BulkEditReviewScreenSample {

  private BulkEditReviewScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Bulk edit review screen",
        "Layout: Selected records, proposed field changes, validation warnings, and impact summary appear before commit. Interaction: Users edit a shared value, review per-record exceptions, confirm, and monitor completion. Variants: Synchronous update, background job, or approval-required bulk change.",
        BlueprintSampleKind.BULK,
        "Selected records, proposed field changes, validation warnings, and impact summary appear before commit.", "Users edit a shared value, review per-record exceptions, confirm, and monitor completion.");
  }
}
