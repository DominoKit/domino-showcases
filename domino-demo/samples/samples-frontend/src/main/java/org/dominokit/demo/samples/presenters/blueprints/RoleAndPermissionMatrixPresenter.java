package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.RoleAndPermissionMatrixView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RoleAndPermissionMatrixPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RoleAndPermissionMatrixPresenter extends ChildPresenter<ShellPresenter, RoleAndPermissionMatrixView>
    implements RoleAndPermissionMatrixView.RoleAndPermissionMatrixUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/role-and-permission-matrix";
}
