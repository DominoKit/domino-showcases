package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class CaseManagementWorkspaceSample {

  private CaseManagementWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Case management workspace",
        "Layout: Case header, status/priority summary, customer or subject details, activity timeline, tasks, and related records. Interaction: Users update status, assign owners, add notes, attach evidence, and resolve/escalate. Variants: Support case, compliance case, incident case, or investigation case.",
        BlueprintSampleKind.WORKFLOW,
        "Case header, status/priority summary, customer or subject details, activity timeline, tasks, and related records.", "Users update status, assign owners, add notes, attach evidence, and resolve/escalate.");
  }
}
