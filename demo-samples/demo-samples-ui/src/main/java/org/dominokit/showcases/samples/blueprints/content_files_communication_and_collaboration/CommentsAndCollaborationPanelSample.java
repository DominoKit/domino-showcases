package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class CommentsAndCollaborationPanelSample {

  private CommentsAndCollaborationPanelSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Comments and collaboration panel",
        "Layout: Primary record/content is accompanied by threaded comments and mentions. Interaction: Users comment, mention, react, resolve, reopen, and filter threads. Variants: Right rail, inline anchored comments, or activity tab.",
        BlueprintSampleKind.CONTENT,
        "Primary record/content is accompanied by threaded comments and mentions.", "Users comment, mention, react, resolve, reopen, and filter threads.");
  }
}
