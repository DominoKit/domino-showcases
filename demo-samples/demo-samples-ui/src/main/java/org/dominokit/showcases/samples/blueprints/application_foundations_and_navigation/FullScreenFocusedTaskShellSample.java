package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class FullScreenFocusedTaskShellSample {

  private FullScreenFocusedTaskShellSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Full-screen focused task shell",
        "Layout: A reduced shell hides secondary navigation and gives one task or workflow most of the viewport. Interaction: Users complete, pause, save, or abandon the focused task. Variants: Wizard shell, review shell, or distraction-free editor.",
        BlueprintSampleKind.NAVIGATION,
        "A reduced shell hides secondary navigation and gives one task or workflow most of the viewport.", "Users complete, pause, save, or abandon the focused task.");
  }
}
