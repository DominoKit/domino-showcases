package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class LoadingAndProgressiveContentScreenSample {

  private LoadingAndProgressiveContentScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Loading and progressive-content screen",
        "Layout: Stable page structure appears immediately while cards, rows, and detail sections load progressively. Interaction: Users can use ready regions while slower regions resolve or retry. Variants: Skeleton loading, staged panels, or table placeholder rows.",
        BlueprintSampleKind.STATE,
        "Stable page structure appears immediately while cards, rows, and detail sections load progressively.", "Users can use ready regions while slower regions resolve or retry.");
  }
}
