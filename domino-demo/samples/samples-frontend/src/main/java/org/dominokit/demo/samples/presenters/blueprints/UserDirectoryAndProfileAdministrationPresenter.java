package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.UserDirectoryAndProfileAdministrationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(UserDirectoryAndProfileAdministrationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class UserDirectoryAndProfileAdministrationPresenter extends ChildPresenter<ShellPresenter, UserDirectoryAndProfileAdministrationView>
    implements UserDirectoryAndProfileAdministrationView.UserDirectoryAndProfileAdministrationUiHandlers {

  public static final String ROUTE = "blueprints/administration-identity-and-security/user-directory-and-profile-administration";
}
