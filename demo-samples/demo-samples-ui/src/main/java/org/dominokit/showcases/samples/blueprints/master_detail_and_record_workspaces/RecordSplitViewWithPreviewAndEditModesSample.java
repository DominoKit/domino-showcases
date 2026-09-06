package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RecordSplitViewWithPreviewAndEditModesSample {

  private RecordSplitViewWithPreviewAndEditModesSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Record split view with preview and edit modes",
        "Layout: Selected record is shown in a preview state and can transition to an edit state in the same pane. Interaction: Users preview, edit, save, cancel, and move between records without leaving the list. Variants: Inline edit, side panel, or full-screen edit escalation.",
        BlueprintSampleKind.DETAIL,
        "Selected record is shown in a preview state and can transition to an edit state in the same pane.", "Users preview, edit, save, cancel, and move between records without leaving the list.");
  }
}
