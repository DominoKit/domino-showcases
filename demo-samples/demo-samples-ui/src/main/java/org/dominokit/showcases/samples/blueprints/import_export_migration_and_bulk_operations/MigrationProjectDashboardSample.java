package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MigrationProjectDashboardSample {

  private MigrationProjectDashboardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Migration project dashboard",
        "Layout: Migration phases, source/target summaries, validation counts, blockers, and run history. Interaction: Users configure mappings, run dry-runs, resolve issues, execute phases, and rollback where supported. Variants: Tenant migration, system migration, or data-version migration.",
        BlueprintSampleKind.BULK,
        "Migration phases, source/target summaries, validation counts, blockers, and run history.", "Users configure mappings, run dry-runs, resolve issues, execute phases, and rollback where supported.");
  }
}
