package org.dominokit.showcases.samples.blueprints.administration_identity_and_security;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AccessPolicyRuleEditorSample {

  private AccessPolicyRuleEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Access policy rule editor",
        "Layout: Policy scope, conditions, effect, exceptions, and priority are edited in a rule-oriented form. Interaction: Users create rules, test a subject/resource combination, reorder precedence, and publish. Variants: Visual policy builder, JSON/code view, or guided form.",
        BlueprintSampleKind.ADMINISTRATION,
        "Policy scope, conditions, effect, exceptions, and priority are edited in a rule-oriented form.", "Users create rules, test a subject/resource combination, reorder precedence, and publish.");
  }
}
