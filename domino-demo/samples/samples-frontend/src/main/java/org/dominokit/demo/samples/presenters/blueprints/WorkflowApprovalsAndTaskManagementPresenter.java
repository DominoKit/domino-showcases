package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.WorkflowApprovalsAndTaskManagementView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/workflow-approvals-and-task-management")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class WorkflowApprovalsAndTaskManagementPresenter extends ChildPresenter<ShellPresenter, WorkflowApprovalsAndTaskManagementView>
    implements WorkflowApprovalsAndTaskManagementView.WorkflowApprovalsAndTaskManagementUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management";
}
