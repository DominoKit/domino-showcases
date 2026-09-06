package org.dominokit.showcases.samples.blueprints.forms_configuration_and_data_entry_flows;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SteppedWizardSample {

  private SteppedWizardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Stepped wizard",
        "Layout: Stepper indicates progress, with one focused form section per step and a final review. Interaction: Users move back and forward, save progress, validate each step, and submit at the end. Variants: Linear required steps, optional steps, or branching steps.",
        BlueprintSampleKind.FORM,
        "Stepper indicates progress, with one focused form section per step and a final review.", "Users move back and forward, save progress, validate each step, and submit at the end.");
  }
}
