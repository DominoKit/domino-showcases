package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.SystemSettingsHubView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SystemSettingsHubPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SystemSettingsHubPresenter extends ChildPresenter<ShellPresenter, SystemSettingsHubView>
    implements SystemSettingsHubView.SystemSettingsHubUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/system-settings-hub";
}
