package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SingleSectionEntityFormSample {

  private SingleSectionEntityFormSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Single-section entity form",
        "Layout: Page title, grouped fields, validation messages, and a clear save/cancel footer. Interaction: Users enter values, see inline validation, save, reset, or cancel. Variants: Inline page, dialog, drawer, or read-only-to-edit transition.",
        BlueprintSampleKind.FORM,
        "Page title, grouped fields, validation messages, and a clear save/cancel footer.", "Users enter values, see inline validation, save, reset, or cancel.");
  }
}
