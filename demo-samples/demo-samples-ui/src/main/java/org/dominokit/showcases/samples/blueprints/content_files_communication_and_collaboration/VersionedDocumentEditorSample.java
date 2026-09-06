package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class VersionedDocumentEditorSample {

  private VersionedDocumentEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Versioned document editor",
        "Layout: Editor is paired with version history, status, reviewers, and change metadata. Interaction: Users save versions, compare revisions, restore, submit for review, and publish. Variants: Side-by-side diff, inline diff, or review comments.",
        BlueprintSampleKind.CONTENT,
        "Editor is paired with version history, status, reviewers, and change metadata.", "Users save versions, compare revisions, restore, submit for review, and publish.");
  }
}
