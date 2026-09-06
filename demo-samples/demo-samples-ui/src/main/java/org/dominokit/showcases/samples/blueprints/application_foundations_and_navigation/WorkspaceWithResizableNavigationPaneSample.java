package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class WorkspaceWithResizableNavigationPaneSample {

  private WorkspaceWithResizableNavigationPaneSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Workspace with resizable navigation pane",
        "Layout: Main content is paired with a draggable navigation or folder pane. Interaction: Users resize, collapse, pin, and select nodes while the content pane updates. Variants: File tree, project tree, saved-search tree, or queue navigation.",
        BlueprintSampleKind.NAVIGATION,
        "Main content is paired with a draggable navigation or folder pane.", "Users resize, collapse, pin, and select nodes while the content pane updates.");
  }
}
