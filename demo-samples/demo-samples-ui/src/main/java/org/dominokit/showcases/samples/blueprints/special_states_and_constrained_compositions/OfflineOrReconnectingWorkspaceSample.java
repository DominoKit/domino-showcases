package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class OfflineOrReconnectingWorkspaceSample {

  private OfflineOrReconnectingWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Offline or reconnecting workspace",
        "Layout: Main content remains usable with visible connection state, queued changes, and synchronization status. Interaction: Users continue work, retry synchronization, inspect conflicts, and recover failed operations. Variants: Field app, intermittent network, or browser-local draft.",
        BlueprintSampleKind.STATE,
        "Main content remains usable with visible connection state, queued changes, and synchronization status.", "Users continue work, retry synchronization, inspect conflicts, and recover failed operations.");
  }
}
