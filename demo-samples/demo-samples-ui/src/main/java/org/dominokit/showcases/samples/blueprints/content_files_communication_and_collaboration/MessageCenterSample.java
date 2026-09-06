package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MessageCenterSample {

  private MessageCenterSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Message center",
        "Layout: Conversation or notification list beside a message/detail pane and composer. Interaction: Users read, reply, forward, archive, search, and mark messages. Variants: Internal inbox, customer messages, or system notifications.",
        BlueprintSampleKind.CONTENT,
        "Conversation or notification list beside a message/detail pane and composer.", "Users read, reply, forward, archive, search, and mark messages.");
  }
}
