package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.TeamWorkQueueView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.TeamWorkQueueSample;

@UiView
public class TeamWorkQueueViewImpl extends SamplePageView<TeamWorkQueueView.TeamWorkQueueUiHandlers>
    implements TeamWorkQueueView {

  @Inject
  public TeamWorkQueueViewImpl() {
    super("Team work queue", "Layout: Queue table includes ownership, priority, age, SLA, and status columns. Interaction: Users assign, reassign, claim, bulk-update, and open work items. Variants: Round-robin queue, skill-based queue, or supervisor view.");
    addSample("Team work queue", "Layout: Queue table includes ownership, priority, age, SLA, and status columns. Interaction: Users assign, reassign, claim, bulk-update, and open work items. Variants: Round-robin queue, skill-based queue, or supervisor view.", TeamWorkQueueSample.class, TeamWorkQueueSample::create);
    initPage();
  }
}
