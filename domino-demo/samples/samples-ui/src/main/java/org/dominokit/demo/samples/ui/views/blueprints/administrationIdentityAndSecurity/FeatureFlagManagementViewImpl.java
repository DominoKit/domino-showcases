package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.FeatureFlagManagementView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.FeatureFlagManagementSample;

@UiView
public class FeatureFlagManagementViewImpl extends SamplePageView<FeatureFlagManagementView.FeatureFlagManagementUiHandlers>
    implements FeatureFlagManagementView {

  @Inject
  public FeatureFlagManagementViewImpl() {
    super("Feature flag management", "Layout: Flag list includes status, environment, targeting, owner, and rollout percentage. Interaction: Users enable, disable, target audiences, schedule changes, and inspect evaluation history. Variants: Environment matrix, gradual rollout, or experiment assignment.");
    addSample("Feature flag management", "Layout: Flag list includes status, environment, targeting, owner, and rollout percentage. Interaction: Users enable, disable, target audiences, schedule changes, and inspect evaluation history. Variants: Environment matrix, gradual rollout, or experiment assignment.", FeatureFlagManagementSample.class, FeatureFlagManagementSample::create);
    initPage();
  }
}
