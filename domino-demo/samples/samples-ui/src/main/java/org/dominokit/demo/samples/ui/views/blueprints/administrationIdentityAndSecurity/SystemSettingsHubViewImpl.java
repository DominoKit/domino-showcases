package org.dominokit.demo.samples.ui.views.blueprints.administrationIdentityAndSecurity;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.administrationIdentityAndSecurity.SystemSettingsHubView;
import org.dominokit.showcases.samples.blueprints.administration_identity_and_security.SystemSettingsHubSample;

@UiView
public class SystemSettingsHubViewImpl extends BlueprintSamplePageView<SystemSettingsHubView.SystemSettingsHubUiHandlers>
    implements SystemSettingsHubView {

  @Inject
  public SystemSettingsHubViewImpl() {
    super("System settings hub", "Layout: Settings navigation groups configuration pages with search and a save/apply area. Interaction: Users find settings, edit values, restore defaults, preview impact, and publish. Variants: Section tabs, category cards, or searchable settings registry.");
    addSample("System settings hub", "Layout: Settings navigation groups configuration pages with search and a save/apply area. Interaction: Users find settings, edit values, restore defaults, preview impact, and publish. Variants: Section tabs, category cards, or searchable settings registry.", SystemSettingsHubSample.class, SystemSettingsHubSample::create);
    initPage();
  }
}
