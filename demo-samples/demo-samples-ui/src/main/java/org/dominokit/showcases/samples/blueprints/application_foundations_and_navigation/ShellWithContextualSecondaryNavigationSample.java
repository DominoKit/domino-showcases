package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ShellWithContextualSecondaryNavigationSample {

  private ShellWithContextualSecondaryNavigationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Shell with contextual secondary navigation",
        "Layout: Global shell plus a page-level tab or sub-navigation bar below the primary header. Interaction: Users move between related views without losing the selected parent record or module. Variants: Horizontal tabs, vertical section navigation, or a local navigation drawer.",
        BlueprintSampleKind.NAVIGATION,
        "Global shell plus a page-level tab or sub-navigation bar below the primary header.", "Users move between related views without losing the selected parent record or module.");
  }
}
