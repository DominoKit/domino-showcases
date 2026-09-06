package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.SlaAndEscalationMonitorView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.SlaAndEscalationMonitorSample;

@UiView
public class SlaAndEscalationMonitorViewImpl extends BlueprintSamplePageView<SlaAndEscalationMonitorView.SlaAndEscalationMonitorUiHandlers>
    implements SlaAndEscalationMonitorView {

  @Inject
  public SlaAndEscalationMonitorViewImpl() {
    super("SLA and escalation monitor", "Layout: Aging buckets, SLA indicators, breached items, and escalation controls summarize work health. Interaction: Users filter by risk, reassign work, extend deadlines with reason, and open the underlying item. Variants: Real-time monitor, daily management report, or team dashboard.");
    addSample("SLA and escalation monitor", "Layout: Aging buckets, SLA indicators, breached items, and escalation controls summarize work health. Interaction: Users filter by risk, reassign work, extend deadlines with reason, and open the underlying item. Variants: Real-time monitor, daily management report, or team dashboard.", SlaAndEscalationMonitorSample.class, SlaAndEscalationMonitorSample::create);
    initPage();
  }
}
