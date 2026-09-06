package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class FeatureFlagManagementSample {

  private FeatureFlagManagementSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Feature flag management",
        "Layout: Flag list includes status, environment, targeting, owner, and rollout percentage. Interaction: Users enable, disable, target audiences, schedule changes, and inspect evaluation history. Variants: Environment matrix, gradual rollout, or experiment assignment.",
        BlueprintSampleKind.ADMINISTRATION,
        "Flag list includes status, environment, targeting, owner, and rollout percentage.", "Users enable, disable, target audiences, schedule changes, and inspect evaluation history.");
  }
}
