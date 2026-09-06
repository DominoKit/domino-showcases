package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class WizardWithReviewAndConfirmStepSample {

  private WizardWithReviewAndConfirmStepSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Wizard with review-and-confirm step",
        "Layout: Data-entry steps are followed by a read-only summary with grouped changes and warnings. Interaction: Users jump back to correct a section, confirm, and submit the complete operation. Variants: Pricing preview, policy acceptance, or batch creation.",
        BlueprintSampleKind.FORM,
        "Data-entry steps are followed by a read-only summary with grouped changes and warnings.", "Users jump back to correct a section, confirm, and submit the complete operation.");
  }
}
