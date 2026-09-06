package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ApiKeyAndIntegrationManagementSample {

  private ApiKeyAndIntegrationManagementSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "API key and integration management",
        "Layout: Credential/integration list with status, scopes, last-used information, and detail editor. Interaction: Users create, rotate, revoke, test, and restrict credentials. Variants: API keys, OAuth clients, webhooks, or service connections.",
        BlueprintSampleKind.ADMINISTRATION,
        "Credential/integration list with status, scopes, last-used information, and detail editor.", "Users create, rotate, revoke, test, and restrict credentials.");
  }
}
