package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MultiRecordComparisonWorkspaceSample {

  private MultiRecordComparisonWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Multi-record comparison workspace",
        "Layout: Two or more records appear in aligned columns with a shared toolbar. Interaction: Users switch compared records, highlight differences, and copy or reconcile values. Variants: Two-way, three-way, or version comparison.",
        BlueprintSampleKind.DETAIL,
        "Two or more records appear in aligned columns with a shared toolbar.", "Users switch compared records, highlight differences, and copy or reconcile values.");
  }
}
