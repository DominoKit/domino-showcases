package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MasterDetailWithPersistentRecordListSample {

  private MasterDetailWithPersistentRecordListSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Master-detail with persistent record list",
        "Layout: Searchable list remains on the left while the selected record fills the right pane. Interaction: Users move through records with next/previous controls or keyboard shortcuts. Variants: Email-like preview, ticket queue, or asset inspection.",
        BlueprintSampleKind.DETAIL,
        "Searchable list remains on the left while the selected record fills the right pane.", "Users move through records with next/previous controls or keyboard shortcuts.");
  }
}
