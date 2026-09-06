package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class TeamWorkQueueSample {

  private TeamWorkQueueSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Team work queue",
        "Layout: Queue table includes ownership, priority, age, SLA, and status columns. Interaction: Users assign, reassign, claim, bulk-update, and open work items. Variants: Round-robin queue, skill-based queue, or supervisor view.",
        BlueprintSampleKind.WORKFLOW,
        "Queue table includes ownership, priority, age, SLA, and status columns.", "Users assign, reassign, claim, bulk-update, and open work items.");
  }
}
