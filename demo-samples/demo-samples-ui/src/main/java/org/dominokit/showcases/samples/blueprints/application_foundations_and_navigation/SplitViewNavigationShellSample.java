package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SplitViewNavigationShellSample {

  private SplitViewNavigationShellSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Split-view navigation shell",
        "Layout: A list or tree remains visible beside a detail/content pane. Interaction: Selecting an item updates the detail pane while preserving the navigation list and its scroll position. Variants: Fixed split, resizable split, or mobile drill-in with back navigation.",
        BlueprintSampleKind.NAVIGATION,
        "A list or tree remains visible beside a detail/content pane.", "Selecting an item updates the detail pane while preserving the navigation list and its scroll position.");
  }
}
