package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.PersonalTaskInboxView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.PersonalTaskInboxSample;

@UiView
public class PersonalTaskInboxViewImpl extends SamplePageView<PersonalTaskInboxView.PersonalTaskInboxUiHandlers>
    implements PersonalTaskInboxView {

  @Inject
  public PersonalTaskInboxViewImpl() {
    super("Personal task inbox", "Layout: Prioritized task list with status filters and a task detail pane or page. Interaction: Users claim, complete, delegate, snooze, or reject tasks. Variants: List-detail split, grouped by due date, or grouped by process.");
    addSample("Personal task inbox", "Layout: Prioritized task list with status filters and a task detail pane or page. Interaction: Users claim, complete, delegate, snooze, or reject tasks. Variants: List-detail split, grouped by due date, or grouped by process.", PersonalTaskInboxSample.class, PersonalTaskInboxSample::create);
    initPage();
  }
}
