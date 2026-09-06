package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.AdministrationIdentityAndSecurityView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/administration-identity-and-security")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AdministrationIdentityAndSecurityPresenter extends ChildPresenter<ShellPresenter, AdministrationIdentityAndSecurityView>
    implements AdministrationIdentityAndSecurityView.AdministrationIdentityAndSecurityUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security";
}
