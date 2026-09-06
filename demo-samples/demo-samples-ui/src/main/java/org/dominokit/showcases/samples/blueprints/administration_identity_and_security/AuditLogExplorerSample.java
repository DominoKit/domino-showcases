package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AuditLogExplorerSample {

  private AuditLogExplorerSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Audit log explorer",
        "Layout: Filterable event table with timestamp, actor, action, target, and expandable payload/detail. Interaction: Users search by actor/action/record, inspect before-after values, and export evidence. Variants: Security log, business audit, or compliance evidence view.",
        BlueprintSampleKind.ADMINISTRATION,
        "Filterable event table with timestamp, actor, action, target, and expandable payload/detail.", "Users search by actor/action/record, inspect before-after values, and export evidence.");
  }
}
