package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AnnouncementAndBroadcastComposerSample {

  private AnnouncementAndBroadcastComposerSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Announcement and broadcast composer",
        "Layout: Audience selector, message editor, scheduling controls, preview, and delivery summary. Interaction: Users target audiences, preview channels, schedule, send, cancel, and inspect delivery. Variants: In-app, email, SMS, or multi-channel broadcast.",
        BlueprintSampleKind.CONTENT,
        "Audience selector, message editor, scheduling controls, preview, and delivery summary.", "Users target audiences, preview channels, schedule, send, cancel, and inspect delivery.");
  }
}
