package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.AuditLogExplorerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AuditLogExplorerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AuditLogExplorerPresenter extends ChildPresenter<ShellPresenter, AuditLogExplorerView>
    implements AuditLogExplorerView.AuditLogExplorerUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/audit-log-explorer";
}
