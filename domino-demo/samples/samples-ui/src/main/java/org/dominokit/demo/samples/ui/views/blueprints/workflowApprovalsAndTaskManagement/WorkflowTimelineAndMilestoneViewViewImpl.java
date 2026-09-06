package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.WorkflowTimelineAndMilestoneViewView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.WorkflowTimelineAndMilestoneViewSample;

@UiView
public class WorkflowTimelineAndMilestoneViewViewImpl extends BlueprintSamplePageView<WorkflowTimelineAndMilestoneViewView.WorkflowTimelineAndMilestoneViewUiHandlers>
    implements WorkflowTimelineAndMilestoneViewView {

  @Inject
  public WorkflowTimelineAndMilestoneViewViewImpl() {
    super("Workflow timeline and milestone view", "Layout: Process stages appear along a timeline with current state, owners, dates, and blockers. Interaction: Users open milestones, complete transitions, add evidence, and inspect history. Variants: Horizontal timeline, vertical timeline, or timeline plus task list.");
    addSample("Workflow timeline and milestone view", "Layout: Process stages appear along a timeline with current state, owners, dates, and blockers. Interaction: Users open milestones, complete transitions, add evidence, and inspect history. Variants: Horizontal timeline, vertical timeline, or timeline plus task list.", WorkflowTimelineAndMilestoneViewSample.class, WorkflowTimelineAndMilestoneViewSample::create);
    initPage();
  }
}
