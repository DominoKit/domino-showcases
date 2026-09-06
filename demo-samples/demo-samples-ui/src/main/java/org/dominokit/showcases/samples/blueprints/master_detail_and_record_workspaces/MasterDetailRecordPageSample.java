package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MasterDetailRecordPageSample {

  private MasterDetailRecordPageSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Master-detail record page",
        "Layout: Summary header and tabbed sections form the detail pane, usually reached from a list. Interaction: Users move between related sections, edit the record, and return to the originating list. Variants: Full page, split view, or nested route tabs.",
        BlueprintSampleKind.DETAIL,
        "Summary header and tabbed sections form the detail pane, usually reached from a list.", "Users move between related sections, edit the record, and return to the originating list.");
  }
}
