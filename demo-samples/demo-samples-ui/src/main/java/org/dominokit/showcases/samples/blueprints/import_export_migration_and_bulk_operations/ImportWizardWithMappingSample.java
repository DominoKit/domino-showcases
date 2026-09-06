package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ImportWizardWithMappingSample {

  private ImportWizardWithMappingSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Import wizard with mapping",
        "Layout: Upload step, column-mapping step, validation preview, and commit summary. Interaction: Users upload data, map source fields, resolve invalid rows, and start the import. Variants: CSV, spreadsheet, JSON, or copied tabular data.",
        BlueprintSampleKind.BULK,
        "Upload step, column-mapping step, validation preview, and commit summary.", "Users upload data, map source fields, resolve invalid rows, and start the import.");
  }
}
