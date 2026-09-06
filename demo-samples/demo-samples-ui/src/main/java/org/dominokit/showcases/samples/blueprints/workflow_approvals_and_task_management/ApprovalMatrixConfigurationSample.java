package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ApprovalMatrixConfigurationSample {

  private ApprovalMatrixConfigurationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Approval matrix configuration",
        "Layout: Rules, thresholds, roles, and escalation paths are shown in a structured editor. Interaction: Administrators add conditions, order approvers, test a rule, and publish changes. Variants: Table editor, visual rule builder, or nested policy editor.",
        BlueprintSampleKind.WORKFLOW,
        "Rules, thresholds, roles, and escalation paths are shown in a structured editor.", "Administrators add conditions, order approvers, test a rule, and publish changes.");
  }
}
