package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ApprovalRequestScreenSample {

  private ApprovalRequestScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Approval request screen",
        "Layout: Request summary, submitted values, supporting evidence, decision controls, and history. Interaction: Reviewers approve, reject, request changes, delegate, or add comments. Variants: Single approver, sequential approval chain, or parallel approvals.",
        BlueprintSampleKind.WORKFLOW,
        "Request summary, submitted values, supporting evidence, decision controls, and history.", "Reviewers approve, reject, request changes, delegate, or add comments.");
  }
}
