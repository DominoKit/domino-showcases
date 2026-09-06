package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.MultiWorkspaceApplicationView;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.MultiWorkspaceApplicationSample;

@UiView
public class MultiWorkspaceApplicationViewImpl extends BlueprintSamplePageView<MultiWorkspaceApplicationView.MultiWorkspaceApplicationUiHandlers>
    implements MultiWorkspaceApplicationView {

  @Inject
  public MultiWorkspaceApplicationViewImpl() {
    super("Multi-workspace application", "Layout: A global workspace switcher controls the active tenant, project, environment, or business unit. Interaction: Users switch contexts and the shell refreshes navigation, permissions, filters, and data. Variants: Dropdown switcher, tabbed workspaces, or recent-workspace launcher.");
    addSample("Multi-workspace application", "Layout: A global workspace switcher controls the active tenant, project, environment, or business unit. Interaction: Users switch contexts and the shell refreshes navigation, permissions, filters, and data. Variants: Dropdown switcher, tabbed workspaces, or recent-workspace launcher.", MultiWorkspaceApplicationSample.class, MultiWorkspaceApplicationSample::create);
    initPage();
  }
}
