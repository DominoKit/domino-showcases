package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class WorkflowTimelineAndMilestoneViewSample {

  private WorkflowTimelineAndMilestoneViewSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Workflow timeline and milestone view",
        "Layout: Process stages appear along a timeline with current state, owners, dates, and blockers. Interaction: Users open milestones, complete transitions, add evidence, and inspect history. Variants: Horizontal timeline, vertical timeline, or timeline plus task list.",
        BlueprintSampleKind.WORKFLOW,
        "Process stages appear along a timeline with current state, owners, dates, and blockers.", "Users open milestones, complete transitions, add evidence, and inspect history.");
  }
}
