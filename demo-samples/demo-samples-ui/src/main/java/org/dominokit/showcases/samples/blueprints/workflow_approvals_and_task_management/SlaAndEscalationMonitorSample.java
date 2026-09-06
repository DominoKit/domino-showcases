package org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SlaAndEscalationMonitorSample {

  private SlaAndEscalationMonitorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "SLA and escalation monitor",
        "Layout: Aging buckets, SLA indicators, breached items, and escalation controls summarize work health. Interaction: Users filter by risk, reassign work, extend deadlines with reason, and open the underlying item. Variants: Real-time monitor, daily management report, or team dashboard.",
        BlueprintSampleKind.WORKFLOW,
        "Aging buckets, SLA indicators, breached items, and escalation controls summarize work health.", "Users filter by risk, reassign work, extend deadlines with reason, and open the underlying item.");
  }
}
