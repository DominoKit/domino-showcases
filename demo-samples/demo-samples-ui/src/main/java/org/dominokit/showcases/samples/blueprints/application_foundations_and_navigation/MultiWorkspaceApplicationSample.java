package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MultiWorkspaceApplicationSample {

  private MultiWorkspaceApplicationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Multi-workspace application",
        "Layout: A global workspace switcher controls the active tenant, project, environment, or business unit. Interaction: Users switch contexts and the shell refreshes navigation, permissions, filters, and data. Variants: Dropdown switcher, tabbed workspaces, or recent-workspace launcher.",
        BlueprintSampleKind.NAVIGATION,
        "A global workspace switcher controls the active tenant, project, environment, or business unit.", "Users switch contexts and the shell refreshes navigation, permissions, filters, and data.");
  }
}
