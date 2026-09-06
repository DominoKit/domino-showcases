package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class OrganizationAndTenantAdministrationSample {

  private OrganizationAndTenantAdministrationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Organization and tenant administration",
        "Layout: Organization tree, tenant metadata, membership summary, and configuration tabs form the workspace. Interaction: Administrators add units, move members, configure defaults, and switch scope. Variants: Company hierarchy, multi-tenant console, or franchise hierarchy.",
        BlueprintSampleKind.ADMINISTRATION,
        "Organization tree, tenant metadata, membership summary, and configuration tabs form the workspace.", "Administrators add units, move members, configure defaults, and switch scope.");
  }
}
