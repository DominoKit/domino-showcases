package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.ApprovalRequestScreenView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.ApprovalRequestScreenSample;

@UiView
public class ApprovalRequestScreenViewImpl extends SamplePageView<ApprovalRequestScreenView.ApprovalRequestScreenUiHandlers>
    implements ApprovalRequestScreenView {

  @Inject
  public ApprovalRequestScreenViewImpl() {
    super("Approval request screen", "Layout: Request summary, submitted values, supporting evidence, decision controls, and history. Interaction: Reviewers approve, reject, request changes, delegate, or add comments. Variants: Single approver, sequential approval chain, or parallel approvals.");
    addSample("Approval request screen", "Layout: Request summary, submitted values, supporting evidence, decision controls, and history. Interaction: Reviewers approve, reject, request changes, delegate, or add comments. Variants: Single approver, sequential approval chain, or parallel approvals.", ApprovalRequestScreenSample.class, ApprovalRequestScreenSample::create);
    initPage();
  }
}
