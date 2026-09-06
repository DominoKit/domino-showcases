package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.TaskDetailWithChecklistView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.TaskDetailWithChecklistSample;

@UiView
public class TaskDetailWithChecklistViewImpl extends SamplePageView<TaskDetailWithChecklistView.TaskDetailWithChecklistUiHandlers>
    implements TaskDetailWithChecklistView {

  @Inject
  public TaskDetailWithChecklistViewImpl() {
    super("Task detail with checklist", "Layout: Task description and owner information are paired with a required/optional checklist and completion evidence. Interaction: Users check items, attach evidence, comment, and complete or return the task. Variants: Inspection checklist, onboarding checklist, or maintenance checklist.");
    addSample("Task detail with checklist", "Layout: Task description and owner information are paired with a required/optional checklist and completion evidence. Interaction: Users check items, attach evidence, comment, and complete or return the task. Variants: Inspection checklist, onboarding checklist, or maintenance checklist.", TaskDetailWithChecklistSample.class, TaskDetailWithChecklistSample::create);
    initPage();
  }
}
