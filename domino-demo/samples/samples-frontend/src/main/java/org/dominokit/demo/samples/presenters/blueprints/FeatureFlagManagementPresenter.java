package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.FeatureFlagManagementView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FeatureFlagManagementPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FeatureFlagManagementPresenter extends ChildPresenter<ShellPresenter, FeatureFlagManagementView>
    implements FeatureFlagManagementView.FeatureFlagManagementUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/feature-flag-management";
}
