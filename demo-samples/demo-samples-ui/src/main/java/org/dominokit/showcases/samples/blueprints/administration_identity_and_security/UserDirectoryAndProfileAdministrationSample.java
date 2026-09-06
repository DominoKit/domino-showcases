package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class UserDirectoryAndProfileAdministrationSample {

  private UserDirectoryAndProfileAdministrationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "User directory and profile administration",
        "Layout: Searchable user list with status, role, organization, and a profile editor/detail pane. Interaction: Administrators invite, edit, disable, reset, impersonate where permitted, and inspect activity. Variants: Employee directory, customer users, or service accounts.",
        BlueprintSampleKind.ADMINISTRATION,
        "Searchable user list with status, role, organization, and a profile editor/detail pane.", "Administrators invite, edit, disable, reset, impersonate where permitted, and inspect activity.");
  }
}
