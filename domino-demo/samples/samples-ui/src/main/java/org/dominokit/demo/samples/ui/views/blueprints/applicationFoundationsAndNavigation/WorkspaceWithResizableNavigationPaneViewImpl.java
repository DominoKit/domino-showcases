package org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.WorkspaceWithResizableNavigationPaneView;
import org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation.WorkspaceWithResizableNavigationPaneSample;

@UiView
public class WorkspaceWithResizableNavigationPaneViewImpl extends BlueprintSamplePageView<WorkspaceWithResizableNavigationPaneView.WorkspaceWithResizableNavigationPaneUiHandlers>
    implements WorkspaceWithResizableNavigationPaneView {

  @Inject
  public WorkspaceWithResizableNavigationPaneViewImpl() {
    super("Workspace with resizable navigation pane", "Layout: Main content is paired with a draggable navigation or folder pane. Interaction: Users resize, collapse, pin, and select nodes while the content pane updates. Variants: File tree, project tree, saved-search tree, or queue navigation.");
    addSample("Workspace with resizable navigation pane", "Layout: Main content is paired with a draggable navigation or folder pane. Interaction: Users resize, collapse, pin, and select nodes while the content pane updates. Variants: File tree, project tree, saved-search tree, or queue navigation.", WorkspaceWithResizableNavigationPaneSample.class, WorkspaceWithResizableNavigationPaneSample::create);
    initPage();
  }
}
