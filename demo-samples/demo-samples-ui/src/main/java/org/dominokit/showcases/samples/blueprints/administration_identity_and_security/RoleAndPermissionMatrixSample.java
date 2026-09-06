package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RoleAndPermissionMatrixSample {

  private RoleAndPermissionMatrixSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Role and permission matrix",
        "Layout: Roles form one axis and permissions/resources form another, often with grouped rows and inheritance indicators. Interaction: Administrators grant, revoke, compare, search, and publish permission changes. Variants: Matrix table, role detail tabs, or resource-first hierarchy.",
        BlueprintSampleKind.ADMINISTRATION,
        "Roles form one axis and permissions/resources form another, often with grouped rows and inheritance indicators.", "Administrators grant, revoke, compare, search, and publish permission changes.");
  }
}
