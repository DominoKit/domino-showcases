package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ConfigurationScreenWithPreviewSample {

  private ConfigurationScreenWithPreviewSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Configuration screen with preview",
        "Layout: Configuration controls occupy one region and a live or sample preview occupies another. Interaction: Users change settings, compare preview states, reset defaults, and publish/apply. Variants: Theme builder, notification template, report layout, or form designer.",
        BlueprintSampleKind.FORM,
        "Configuration controls occupy one region and a live or sample preview occupies another.", "Users change settings, compare preview states, reset defaults, and publish/apply.");
  }
}
