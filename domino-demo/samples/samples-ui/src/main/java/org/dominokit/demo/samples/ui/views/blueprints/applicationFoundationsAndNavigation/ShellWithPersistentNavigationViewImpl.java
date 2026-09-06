package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.ShellWithPersistentNavigationView;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.ShellWithPersistentNavigationSample;

@UiView
public class ShellWithPersistentNavigationViewImpl extends SamplePageView<ShellWithPersistentNavigationView.ShellWithPersistentNavigationUiHandlers>
    implements ShellWithPersistentNavigationView {

  @Inject
  public ShellWithPersistentNavigationViewImpl() {
    super("Shell with persistent navigation", "Layout: Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. Interaction: Users switch modules from the navigation while the shell preserves context, theme, and session actions. Variants: Fixed or overlay navigation; compact icon rail; mobile drawer.");
    addSample("Shell with persistent navigation", "Layout: Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. Interaction: Users switch modules from the navigation while the shell preserves context, theme, and session actions. Variants: Fixed or overlay navigation; compact icon rail; mobile drawer.", ShellWithPersistentNavigationSample.class, ShellWithPersistentNavigationSample::create);
    initPage();
  }
}
