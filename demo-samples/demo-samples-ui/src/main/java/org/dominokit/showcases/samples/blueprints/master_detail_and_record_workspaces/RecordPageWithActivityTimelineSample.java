package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RecordPageWithActivityTimelineSample {

  private RecordPageWithActivityTimelineSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Record page with activity timeline",
        "Layout: Primary record details occupy one region and a chronological activity stream occupies another. Interaction: Users post notes, filter event types, expand events, and respond to tasks. Variants: Right rail, bottom timeline, or full-width activity tab.",
        BlueprintSampleKind.DETAIL,
        "Primary record details occupy one region and a chronological activity stream occupies another.", "Users post notes, filter event types, expand events, and respond to tasks.");
  }
}
