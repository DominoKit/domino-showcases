package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.RoleAndPermissionMatrixView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.RoleAndPermissionMatrixSample;

@UiView
public class RoleAndPermissionMatrixViewImpl extends BlueprintSamplePageView<RoleAndPermissionMatrixView.RoleAndPermissionMatrixUiHandlers>
    implements RoleAndPermissionMatrixView {

  @Inject
  public RoleAndPermissionMatrixViewImpl() {
    super("Role and permission matrix", "Layout: Roles form one axis and permissions/resources form another, often with grouped rows and inheritance indicators. Interaction: Administrators grant, revoke, compare, search, and publish permission changes. Variants: Matrix table, role detail tabs, or resource-first hierarchy.");
    addSample("Role and permission matrix", "Layout: Roles form one axis and permissions/resources form another, often with grouped rows and inheritance indicators. Interaction: Administrators grant, revoke, compare, search, and publish permission changes. Variants: Matrix table, role detail tabs, or resource-first hierarchy.", RoleAndPermissionMatrixSample.class, RoleAndPermissionMatrixSample::create);
    initPage();
  }
}
