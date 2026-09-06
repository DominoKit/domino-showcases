package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ErrorRecoveryScreenSample {

  private ErrorRecoveryScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Error recovery screen",
        "Layout: Failed content is localized with a clear explanation, affected region, retry action, and optional diagnostic detail. Interaction: Users retry, change filters, report the issue, or continue with unaffected content. Variants: Full-page failure, partial panel failure, or failed mutation recovery.",
        BlueprintSampleKind.STATE,
        "Failed content is localized with a clear explanation, affected region, retry action, and optional diagnostic detail.", "Users retry, change filters, report the issue, or continue with unaffected content.");
  }
}
