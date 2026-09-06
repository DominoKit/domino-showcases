package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RecordPageWithSideInspectorSample {

  private RecordPageWithSideInspectorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Record page with side inspector",
        "Layout: Main content displays the record while a narrow inspector exposes metadata, ownership, permissions, or quick actions. Interaction: Users pin/unpin the inspector, change metadata, and execute contextual actions. Variants: Collapsible inspector, overlay inspector, or mobile bottom sheet.",
        BlueprintSampleKind.DETAIL,
        "Main content displays the record while a narrow inspector exposes metadata, ownership, permissions, or quick actions.", "Users pin/unpin the inspector, change metadata, and execute contextual actions.");
  }
}
