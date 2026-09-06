package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ExportBuilderSample {

  private ExportBuilderSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Export builder",
        "Layout: Dataset selection, columns, filters, format, and delivery options are arranged as a short flow or form. Interaction: Users configure, preview, generate, download, or schedule an export. Variants: Immediate download, queued export, or recurring export.",
        BlueprintSampleKind.BULK,
        "Dataset selection, columns, filters, format, and delivery options are arranged as a short flow or form.", "Users configure, preview, generate, download, or schedule an export.");
  }
}
