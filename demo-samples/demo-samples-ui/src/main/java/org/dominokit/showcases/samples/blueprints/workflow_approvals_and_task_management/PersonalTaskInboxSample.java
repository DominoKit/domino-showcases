package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class PersonalTaskInboxSample {

  private PersonalTaskInboxSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Personal task inbox",
        "Layout: Prioritized task list with status filters and a task detail pane or page. Interaction: Users claim, complete, delegate, snooze, or reject tasks. Variants: List-detail split, grouped by due date, or grouped by process.",
        BlueprintSampleKind.WORKFLOW,
        "Prioritized task list with status filters and a task detail pane or page.", "Users claim, complete, delegate, snooze, or reject tasks.");
  }
}
