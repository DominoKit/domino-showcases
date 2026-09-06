package org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.SplitViewNavigationShellView;
import org.dominokit.showcases.samples.blueprints.page_layout_and_navigation.SplitViewNavigationShellSample;

@UiView
public class SplitViewNavigationShellViewImpl extends BlueprintSamplePageView<SplitViewNavigationShellView.SplitViewNavigationShellUiHandlers>
    implements SplitViewNavigationShellView {

  @Inject
  public SplitViewNavigationShellViewImpl() {
    super("Split-view navigation shell", "Layout: A list or tree remains visible beside a detail/content pane. Interaction: Selecting an item updates the detail pane while preserving the navigation list and its scroll position. Variants: Fixed split, resizable split, or mobile drill-in with back navigation.");
    addSample("Split-view navigation shell", "Layout: A list or tree remains visible beside a detail/content pane. Interaction: Selecting an item updates the detail pane while preserving the navigation list and its scroll position. Variants: Fixed split, resizable split, or mobile drill-in with back navigation.", SplitViewNavigationShellSample.class, SplitViewNavigationShellSample::create);
    initPage();
  }
}
