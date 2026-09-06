package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class UnsavedChangesProtectionSample {

  private UnsavedChangesProtectionSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Unsaved-changes protection",
        "Layout: Editable screen includes dirty-state indicators and an explicit save/cancel footer or toolbar. Interaction: Users save, discard, continue editing, or resolve navigation/unload warnings. Variants: Single form, multi-tab form, or multi-record editing.",
        BlueprintSampleKind.STATE,
        "Editable screen includes dirty-state indicators and an explicit save/cancel footer or toolbar.", "Users save, discard, continue editing, or resolve navigation/unload warnings.");
  }
}
