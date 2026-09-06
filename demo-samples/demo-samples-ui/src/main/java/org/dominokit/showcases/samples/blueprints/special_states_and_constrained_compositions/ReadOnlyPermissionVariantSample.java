package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ReadOnlyPermissionVariantSample {

  private ReadOnlyPermissionVariantSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Read-only permission variant",
        "Layout: Editing controls are removed or replaced with explanatory permission messaging while the information hierarchy remains intact. Interaction: Users inspect, copy, export where allowed, or request access. Variants: Field-level masking, section-level read-only, or complete read-only page.",
        BlueprintSampleKind.STATE,
        "Editing controls are removed or replaced with explanatory permission messaging while the information hierarchy remains intact.", "Users inspect, copy, export where allowed, or request access.");
  }
}
