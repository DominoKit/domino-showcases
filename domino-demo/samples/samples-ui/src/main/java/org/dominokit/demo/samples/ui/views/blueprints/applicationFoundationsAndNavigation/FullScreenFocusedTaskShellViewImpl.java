package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.FullScreenFocusedTaskShellView;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.FullScreenFocusedTaskShellSample;

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
