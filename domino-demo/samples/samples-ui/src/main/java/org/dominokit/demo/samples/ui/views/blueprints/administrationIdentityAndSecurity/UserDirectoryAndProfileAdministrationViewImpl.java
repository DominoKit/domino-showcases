package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.UserDirectoryAndProfileAdministrationView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.UserDirectoryAndProfileAdministrationSample;

@UiView
public class UserDirectoryAndProfileAdministrationViewImpl extends SamplePageView<UserDirectoryAndProfileAdministrationView.UserDirectoryAndProfileAdministrationUiHandlers>
    implements UserDirectoryAndProfileAdministrationView {

  @Inject
  public UserDirectoryAndProfileAdministrationViewImpl() {
    super("User directory and profile administration", "Layout: Searchable user list with status, role, organization, and a profile editor/detail pane. Interaction: Administrators invite, edit, disable, reset, impersonate where permitted, and inspect activity. Variants: Employee directory, customer users, or service accounts.");
    addSample("User directory and profile administration", "Layout: Searchable user list with status, role, organization, and a profile editor/detail pane. Interaction: Administrators invite, edit, disable, reset, impersonate where permitted, and inspect activity. Variants: Employee directory, customer users, or service accounts.", UserDirectoryAndProfileAdministrationSample.class, UserDirectoryAndProfileAdministrationSample::create);
    initPage();
  }
}
