package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ShellWithPersistentNavigationSample {

  private ShellWithPersistentNavigationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Shell with persistent navigation",
        "Layout: Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region. Interaction: Users switch modules from the navigation while the shell preserves context, theme, and session actions. Variants: Fixed or overlay navigation; compact icon rail; mobile drawer.",
        BlueprintSampleKind.NAVIGATION,
        "Global header, collapsible left navigation, breadcrumb/current-location area, and a routed content region.", "Users switch modules from the navigation while the shell preserves context, theme, and session actions.");
  }
}
