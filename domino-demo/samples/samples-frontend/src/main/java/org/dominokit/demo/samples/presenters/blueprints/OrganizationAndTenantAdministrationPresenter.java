package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.OrganizationAndTenantAdministrationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(OrganizationAndTenantAdministrationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class OrganizationAndTenantAdministrationPresenter extends ChildPresenter<ShellPresenter, OrganizationAndTenantAdministrationView>
    implements OrganizationAndTenantAdministrationView.OrganizationAndTenantAdministrationUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/organization-and-tenant-administration";
}
