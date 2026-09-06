package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.ShellWithContextualSecondaryNavigationView;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.ShellWithContextualSecondaryNavigationSample;

@UiView
public class ShellWithContextualSecondaryNavigationViewImpl extends SamplePageView<ShellWithContextualSecondaryNavigationView.ShellWithContextualSecondaryNavigationUiHandlers>
    implements ShellWithContextualSecondaryNavigationView {

  @Inject
  public ShellWithContextualSecondaryNavigationViewImpl() {
    super("Shell with contextual secondary navigation", "Layout: Global shell plus a page-level tab or sub-navigation bar below the primary header. Interaction: Users move between related views without losing the selected parent record or module. Variants: Horizontal tabs, vertical section navigation, or a local navigation drawer.");
    addSample("Shell with contextual secondary navigation", "Layout: Global shell plus a page-level tab or sub-navigation bar below the primary header. Interaction: Users move between related views without losing the selected parent record or module. Variants: Horizontal tabs, vertical section navigation, or a local navigation drawer.", ShellWithContextualSecondaryNavigationSample.class, ShellWithContextualSecondaryNavigationSample::create);
    initPage();
  }
}
