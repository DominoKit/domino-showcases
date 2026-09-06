package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class FormWithConditionalFieldsSample {

  private FormWithConditionalFieldsSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Form with conditional fields",
        "Layout: Base fields are visible and dependent sections appear based on selections. Interaction: Users make choices that reveal, hide, enable, or reset related fields. Variants: Rule-driven forms, product configuration, or eligibility forms.",
        BlueprintSampleKind.FORM,
        "Base fields are visible and dependent sections appear based on selections.", "Users make choices that reveal, hide, enable, or reset related fields.");
  }
}
