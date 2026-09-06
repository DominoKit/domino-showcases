package org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.PageWithPersistentNavigationView;
import org.dominokit.showcases.samples.blueprints.page_layout_and_navigation.PageWithPersistentNavigationSample;

@UiView
public class PageWithPersistentNavigationViewImpl extends BlueprintSamplePageView<PageWithPersistentNavigationView.PageWithPersistentNavigationUiHandlers>
    implements PageWithPersistentNavigationView {

  @Inject
  public PageWithPersistentNavigationViewImpl() {
    super("Page with persistent navigation", "Layout: Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. Interaction: Users switch modules from the navigation while the shell preserves context, theme, and session actions. Variants: Fixed or overlay navigation; compact icon rail; mobile drawer.");
    addSample("Page with persistent navigation", "Layout: Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. Interaction: Users switch modules from the navigation while the shell preserves context, theme, and session actions. Variants: Fixed or overlay navigation; compact icon rail; mobile drawer.", PageWithPersistentNavigationSample.class, PageWithPersistentNavigationSample::create);
    initPage();
  }
}
