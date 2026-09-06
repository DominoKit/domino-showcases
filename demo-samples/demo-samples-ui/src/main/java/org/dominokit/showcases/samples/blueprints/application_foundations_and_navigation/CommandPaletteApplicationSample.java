package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class CommandPaletteApplicationSample {

  private CommandPaletteApplicationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Command palette application",
        "Layout: Minimal shell with a global command/search trigger and an optional keyboard-shortcut hint. Interaction: Users search for pages, records, actions, or settings and execute commands without navigating menus. Variants: Modal palette, inline command bar, or command palette with recent actions.",
        BlueprintSampleKind.NAVIGATION,
        "Minimal shell with a global command/search trigger and an optional keyboard-shortcut hint.", "Users search for pages, records, actions, or settings and execute commands without navigating menus.");
  }
}
