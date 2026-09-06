package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class EmptyStateFirstScreenSample {

  private EmptyStateFirstScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Empty-state-first screen",
        "Layout: The normal page shell is present but the primary content area explains the absence of records and offers a clear next action. Interaction: Users create the first record, import data, adjust filters, or learn more. Variants: First-use empty state, filtered-empty state, or permission-empty state.",
        BlueprintSampleKind.STATE,
        "The normal page shell is present but the primary content area explains the absence of records and offers a clear next action.", "Users create the first record, import data, adjust filters, or learn more.");
  }
}
