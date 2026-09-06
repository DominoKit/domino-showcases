package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SystemSettingsHubSample {

  private SystemSettingsHubSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "System settings hub",
        "Layout: Settings navigation groups configuration pages with search and a save/apply area. Interaction: Users find settings, edit values, restore defaults, preview impact, and publish. Variants: Section tabs, category cards, or searchable settings registry.",
        BlueprintSampleKind.ADMINISTRATION,
        "Settings navigation groups configuration pages with search and a save/apply area.", "Users find settings, edit values, restore defaults, preview impact, and publish.");
  }
}
