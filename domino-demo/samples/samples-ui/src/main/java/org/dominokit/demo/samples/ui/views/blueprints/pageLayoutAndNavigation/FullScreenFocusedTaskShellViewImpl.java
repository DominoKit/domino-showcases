package org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.FullScreenFocusedTaskShellView;
import org.dominokit.showcases.samples.blueprints.page_layout_and_navigation.FullScreenFocusedTaskShellSample;

@UiView
public class FullScreenFocusedTaskShellViewImpl extends BlueprintSamplePageView<FullScreenFocusedTaskShellView.FullScreenFocusedTaskShellUiHandlers>
    implements FullScreenFocusedTaskShellView {

  @Inject
  public FullScreenFocusedTaskShellViewImpl() {
    super("Full-screen focused task shell", "Layout: A reduced shell hides secondary navigation and gives one task or workflow most of the viewport. Interaction: Users complete, pause, save, or abandon the focused task. Variants: Wizard shell, review shell, or distraction-free editor.");
    addSample("Full-screen focused task shell", "Layout: A reduced shell hides secondary navigation and gives one task or workflow most of the viewport. Interaction: Users complete, pause, save, or abandon the focused task. Variants: Wizard shell, review shell, or distraction-free editor.", FullScreenFocusedTaskShellSample.class, FullScreenFocusedTaskShellSample::create);
    initPage();
  }
}
