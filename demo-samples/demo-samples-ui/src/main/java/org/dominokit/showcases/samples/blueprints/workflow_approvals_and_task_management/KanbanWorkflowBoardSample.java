package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class KanbanWorkflowBoardSample {

  private KanbanWorkflowBoardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Kanban workflow board",
        "Layout: Columns represent workflow states and cards represent work items. Interaction: Users drag cards between states, open details, assign owners, and filter the board. Variants: WIP limits, swimlanes, card grouping, or keyboard-accessible movement.",
        BlueprintSampleKind.WORKFLOW,
        "Columns represent workflow states and cards represent work items.", "Users drag cards between states, open details, assign owners, and filter the board.");
  }
}
