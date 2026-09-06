package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.CaseManagementWorkspaceView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(CaseManagementWorkspacePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class CaseManagementWorkspacePresenter extends ChildPresenter<ShellPresenter, CaseManagementWorkspaceView>
    implements CaseManagementWorkspaceView.CaseManagementWorkspaceUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management/case-management-workspace";
}
