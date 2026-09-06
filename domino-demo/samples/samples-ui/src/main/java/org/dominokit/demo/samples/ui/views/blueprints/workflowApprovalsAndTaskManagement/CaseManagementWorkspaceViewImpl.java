package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.CaseManagementWorkspaceView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.CaseManagementWorkspaceSample;

@UiView
public class CaseManagementWorkspaceViewImpl extends SamplePageView<CaseManagementWorkspaceView.CaseManagementWorkspaceUiHandlers>
    implements CaseManagementWorkspaceView {

  @Inject
  public CaseManagementWorkspaceViewImpl() {
    super("Case management workspace", "Layout: Case header, status/priority summary, customer or subject details, activity timeline, tasks, and related records. Interaction: Users update status, assign owners, add notes, attach evidence, and resolve/escalate. Variants: Support case, compliance case, incident case, or investigation case.");
    addSample("Case management workspace", "Layout: Case header, status/priority summary, customer or subject details, activity timeline, tasks, and related records. Interaction: Users update status, assign owners, add notes, attach evidence, and resolve/escalate. Variants: Support case, compliance case, incident case, or investigation case.", CaseManagementWorkspaceSample.class, CaseManagementWorkspaceSample::create);
    initPage();
  }
}
