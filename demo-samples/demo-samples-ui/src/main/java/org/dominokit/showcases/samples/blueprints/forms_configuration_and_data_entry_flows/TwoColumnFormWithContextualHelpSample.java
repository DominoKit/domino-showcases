package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class TwoColumnFormWithContextualHelpSample {

  private TwoColumnFormWithContextualHelpSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Two-column form with contextual help",
        "Layout: Fields occupy a primary column while descriptions, examples, or help occupy a secondary column. Interaction: Users fill fields while consulting inline help, tooltips, or documentation links. Variants: Help rail, inline expandable help, or responsive stacked layout.",
        BlueprintSampleKind.FORM,
        "Fields occupy a primary column while descriptions, examples, or help occupy a secondary column.", "Users fill fields while consulting inline help, tooltips, or documentation links.");
  }
}
