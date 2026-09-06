package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.OrganizationAndTenantAdministrationView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.OrganizationAndTenantAdministrationSample;

@UiView
public class OrganizationAndTenantAdministrationViewImpl extends BlueprintSamplePageView<OrganizationAndTenantAdministrationView.OrganizationAndTenantAdministrationUiHandlers>
    implements OrganizationAndTenantAdministrationView {

  @Inject
  public OrganizationAndTenantAdministrationViewImpl() {
    super("Organization and tenant administration", "Layout: Organization tree, tenant metadata, membership summary, and configuration tabs form the workspace. Interaction: Administrators add units, move members, configure defaults, and switch scope. Variants: Company hierarchy, multi-tenant console, or franchise hierarchy.");
    addSample("Organization and tenant administration", "Layout: Organization tree, tenant metadata, membership summary, and configuration tabs form the workspace. Interaction: Administrators add units, move members, configure defaults, and switch scope. Variants: Company hierarchy, multi-tenant console, or franchise hierarchy.", OrganizationAndTenantAdministrationSample.class, OrganizationAndTenantAdministrationSample::create);
    initPage();
  }
}
