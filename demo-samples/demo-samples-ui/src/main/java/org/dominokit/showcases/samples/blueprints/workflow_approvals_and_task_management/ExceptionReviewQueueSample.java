package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ExceptionReviewQueueSample {

  private ExceptionReviewQueueSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Exception review queue",
        "Layout: Failed, suspicious, or incomplete items appear in a queue with reason and severity. Interaction: Users inspect evidence, correct data, retry processing, suppress, or escalate. Variants: Batch exception review, fraud review, or integration error queue.",
        BlueprintSampleKind.WORKFLOW,
        "Failed, suspicious, or incomplete items appear in a queue with reason and severity.", "Users inspect evidence, correct data, retry processing, suppress, or escalate.");
  }
}
