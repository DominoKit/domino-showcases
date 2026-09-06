package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RecordOverviewWithRelatedEntitiesSample {

  private RecordOverviewWithRelatedEntitiesSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Record overview with related entities",
        "Layout: Record header is followed by summary cards and related lists for contacts, transactions, files, or activities. Interaction: Users navigate among related entities, add related records, and return to the parent context. Variants: Tabs, stacked sections, or dashboard-like summary.",
        BlueprintSampleKind.DETAIL,
        "Record header is followed by summary cards and related lists for contacts, transactions, files, or activities.", "Users navigate among related entities, add related records, and return to the parent context.");
  }
}
