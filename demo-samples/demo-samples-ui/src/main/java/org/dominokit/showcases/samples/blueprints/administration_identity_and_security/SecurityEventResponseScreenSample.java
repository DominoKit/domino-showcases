package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SecurityEventResponseScreenSample {

  private SecurityEventResponseScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Security event response screen",
        "Layout: Alert summary, affected identities/resources, evidence, timeline, and response actions. Interaction: Analysts acknowledge, investigate, contain, assign, and close an event. Variants: Incident response, suspicious login review, or policy violation review.",
        BlueprintSampleKind.ADMINISTRATION,
        "Alert summary, affected identities/resources, evidence, timeline, and response actions.", "Analysts acknowledge, investigate, contain, assign, and close an event.");
  }
}
