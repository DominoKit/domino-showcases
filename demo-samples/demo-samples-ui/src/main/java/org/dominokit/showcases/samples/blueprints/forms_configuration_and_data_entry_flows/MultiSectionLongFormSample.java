package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MultiSectionLongFormSample {

  private MultiSectionLongFormSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Multi-section long form",
        "Layout: Form is divided into titled sections with a summary or anchored section navigation. Interaction: Users navigate sections, see completion/validation status, save a draft, and submit. Variants: Accordion sections, sticky section nav, or progressive disclosure.",
        BlueprintSampleKind.FORM,
        "Form is divided into titled sections with a summary or anchored section navigation.", "Users navigate sections, see completion/validation status, save a draft, and submit.");
  }
}
