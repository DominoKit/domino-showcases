package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.ApiKeyAndIntegrationManagementView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ApiKeyAndIntegrationManagementPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ApiKeyAndIntegrationManagementPresenter extends ChildPresenter<ShellPresenter, ApiKeyAndIntegrationManagementView>
    implements ApiKeyAndIntegrationManagementView.ApiKeyAndIntegrationManagementUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/api-key-and-integration-management";
}
