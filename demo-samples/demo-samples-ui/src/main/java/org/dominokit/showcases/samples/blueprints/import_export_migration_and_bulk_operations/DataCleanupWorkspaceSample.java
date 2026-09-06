package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DataCleanupWorkspaceSample {

  private DataCleanupWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Data cleanup workspace",
        "Layout: Duplicate/invalid candidates, matching rules, previewed merges, and action history are presented together. Interaction: Users review candidates, merge/suppress, apply rules, and undo where possible. Variants: Duplicate contacts, catalog cleanup, or master-data cleanup.",
        BlueprintSampleKind.BULK,
        "Duplicate/invalid candidates, matching rules, previewed merges, and action history are presented together.", "Users review candidates, merge/suppress, apply rules, and undo where possible.");
  }
}
