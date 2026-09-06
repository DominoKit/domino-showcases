package org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DataExchangeStatusCenterSample {

  private DataExchangeStatusCenterSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Data exchange status center",
        "Layout: Inbound/outbound exchanges are listed with direction, schedule, status, volume, and last successful run. Interaction: Users inspect an exchange, retry, download artifacts, and configure notifications. Variants: Partner exchange, regulatory submission, or scheduled feed.",
        BlueprintSampleKind.BULK,
        "Inbound/outbound exchanges are listed with direction, schedule, status, volume, and last successful run.", "Users inspect an exchange, retry, download artifacts, and configure notifications.");
  }
}
