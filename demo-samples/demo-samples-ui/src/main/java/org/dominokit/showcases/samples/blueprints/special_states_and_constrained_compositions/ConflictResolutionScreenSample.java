package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ConflictResolutionScreenSample {

  private ConflictResolutionScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Conflict-resolution screen",
        "Layout: Local changes and current server values are shown side by side or in a field-level conflict list. Interaction: Users keep local, accept remote, merge fields, and retry the save. Variants: Record conflict, document conflict, or concurrent bulk-change conflict.",
        BlueprintSampleKind.STATE,
        "Local changes and current server values are shown side by side or in a field-level conflict list.", "Users keep local, accept remote, merge fields, and retry the save.");
  }
}
