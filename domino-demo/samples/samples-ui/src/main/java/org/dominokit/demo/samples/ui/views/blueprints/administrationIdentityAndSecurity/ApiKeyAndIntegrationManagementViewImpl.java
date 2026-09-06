package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.ApiKeyAndIntegrationManagementView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.ApiKeyAndIntegrationManagementSample;

@UiView
public class ApiKeyAndIntegrationManagementViewImpl extends BlueprintSamplePageView<ApiKeyAndIntegrationManagementView.ApiKeyAndIntegrationManagementUiHandlers>
    implements ApiKeyAndIntegrationManagementView {

  @Inject
  public ApiKeyAndIntegrationManagementViewImpl() {
    super("API key and integration management", "Layout: Credential/integration list with status, scopes, last-used information, and detail editor. Interaction: Users create, rotate, revoke, test, and restrict credentials. Variants: API keys, OAuth clients, webhooks, or service connections.");
    addSample("API key and integration management", "Layout: Credential/integration list with status, scopes, last-used information, and detail editor. Interaction: Users create, rotate, revoke, test, and restrict credentials. Variants: API keys, OAuth clients, webhooks, or service connections.", ApiKeyAndIntegrationManagementSample.class, ApiKeyAndIntegrationManagementSample::create);
    initPage();
  }
}
