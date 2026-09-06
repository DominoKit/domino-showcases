package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AlertTriageScreenSample {

  private AlertTriageScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Alert triage screen",
        "Layout: Alert queue with severity, source, age, owner, and a detail/evidence panel. Interaction: Users acknowledge, suppress, group, assign, escalate, and resolve alerts. Variants: Security, infrastructure, business-rule, or data-quality alerts.",
        BlueprintSampleKind.OPERATIONS,
        "Alert queue with severity, source, age, owner, and a detail/evidence panel.", "Users acknowledge, suppress, group, assign, escalate, and resolve alerts.");
  }
}
