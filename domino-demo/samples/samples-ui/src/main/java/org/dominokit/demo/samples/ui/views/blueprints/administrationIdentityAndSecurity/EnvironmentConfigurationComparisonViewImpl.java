package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.EnvironmentConfigurationComparisonView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.EnvironmentConfigurationComparisonSample;

@UiView
public class EnvironmentConfigurationComparisonViewImpl extends SamplePageView<EnvironmentConfigurationComparisonView.EnvironmentConfigurationComparisonUiHandlers>
    implements EnvironmentConfigurationComparisonView {

  @Inject
  public EnvironmentConfigurationComparisonViewImpl() {
    super("Environment/configuration comparison", "Layout: Two environments or configuration versions are shown in aligned sections with differences highlighted. Interaction: Users compare, select changes, promote, rollback, or export a diff. Variants: Dev/test/prod, tenant-to-tenant, or version-to-version comparison.");
    addSample("Environment/configuration comparison", "Layout: Two environments or configuration versions are shown in aligned sections with differences highlighted. Interaction: Users compare, select changes, promote, rollback, or export a diff. Variants: Dev/test/prod, tenant-to-tenant, or version-to-version comparison.", EnvironmentConfigurationComparisonSample.class, EnvironmentConfigurationComparisonSample::create);
    initPage();
  }
}
