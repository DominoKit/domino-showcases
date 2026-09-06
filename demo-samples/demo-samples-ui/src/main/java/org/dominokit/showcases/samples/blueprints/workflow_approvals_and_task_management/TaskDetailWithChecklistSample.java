package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class TaskDetailWithChecklistSample {

  private TaskDetailWithChecklistSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Task detail with checklist",
        "Layout: Task description and owner information are paired with a required/optional checklist and completion evidence. Interaction: Users check items, attach evidence, comment, and complete or return the task. Variants: Inspection checklist, onboarding checklist, or maintenance checklist.",
        BlueprintSampleKind.WORKFLOW,
        "Task description and owner information are paired with a required/optional checklist and completion evidence.", "Users check items, attach evidence, comment, and complete or return the task.");
  }
}
