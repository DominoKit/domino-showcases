package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.SecurityEventResponseScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SecurityEventResponseScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SecurityEventResponseScreenPresenter extends ChildPresenter<ShellPresenter, SecurityEventResponseScreenView>
    implements SecurityEventResponseScreenView.SecurityEventResponseScreenUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/security-event-response-screen";
}
