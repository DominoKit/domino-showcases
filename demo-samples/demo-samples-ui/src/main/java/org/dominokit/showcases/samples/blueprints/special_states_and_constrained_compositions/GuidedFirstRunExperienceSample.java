package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class GuidedFirstRunExperienceSample {

  private GuidedFirstRunExperienceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Guided first-run experience",
        "Layout: Empty or lightly populated workspace is paired with onboarding steps, contextual tips, and sample actions. Interaction: Users complete setup, skip or resume guidance, and reach the first meaningful result. Variants: Product onboarding, tenant setup, or feature-specific tour.",
        BlueprintSampleKind.STATE,
        "Empty or lightly populated workspace is paired with onboarding steps, contextual tips, and sample actions.", "Users complete setup, skip or resume guidance, and reach the first meaningful result.");
  }
}
