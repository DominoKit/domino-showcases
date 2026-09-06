package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.ApprovalMatrixConfigurationView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.ApprovalMatrixConfigurationSample;

@UiView
public class ApprovalMatrixConfigurationViewImpl extends SamplePageView<ApprovalMatrixConfigurationView.ApprovalMatrixConfigurationUiHandlers>
    implements ApprovalMatrixConfigurationView {

  @Inject
  public ApprovalMatrixConfigurationViewImpl() {
    super("Approval matrix configuration", "Layout: Rules, thresholds, roles, and escalation paths are shown in a structured editor. Interaction: Administrators add conditions, order approvers, test a rule, and publish changes. Variants: Table editor, visual rule builder, or nested policy editor.");
    addSample("Approval matrix configuration", "Layout: Rules, thresholds, roles, and escalation paths are shown in a structured editor. Interaction: Administrators add conditions, order approvers, test a rule, and publish changes. Variants: Table editor, visual rule builder, or nested policy editor.", ApprovalMatrixConfigurationSample.class, ApprovalMatrixConfigurationSample::create);
    initPage();
  }
}
