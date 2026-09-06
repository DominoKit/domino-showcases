package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ImportValidationAndCorrectionQueueSample {

  private ImportValidationAndCorrectionQueueSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Import validation and correction queue",
        "Layout: Valid rows and invalid rows are summarized with an error table and correction editor. Interaction: Users fix values inline, download errors, revalidate, and continue or cancel. Variants: Row-level correction, cell-level correction, or rules-assisted correction.",
        BlueprintSampleKind.BULK,
        "Valid rows and invalid rows are summarized with an error table and correction editor.", "Users fix values inline, download errors, revalidate, and continue or cancel.");
  }
}
