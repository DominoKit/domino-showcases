package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class EnvironmentConfigurationComparisonSample {

  private EnvironmentConfigurationComparisonSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Environment/configuration comparison",
        "Layout: Two environments or configuration versions are shown in aligned sections with differences highlighted. Interaction: Users compare, select changes, promote, rollback, or export a diff. Variants: Dev/test/prod, tenant-to-tenant, or version-to-version comparison.",
        BlueprintSampleKind.ADMINISTRATION,
        "Two environments or configuration versions are shown in aligned sections with differences highlighted.", "Users compare, select changes, promote, rollback, or export a diff.");
  }
}
