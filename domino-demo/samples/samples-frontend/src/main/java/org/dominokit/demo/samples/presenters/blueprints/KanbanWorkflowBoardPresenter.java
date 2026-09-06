package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.KanbanWorkflowBoardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(KanbanWorkflowBoardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class KanbanWorkflowBoardPresenter extends ChildPresenter<ShellPresenter, KanbanWorkflowBoardView>
    implements KanbanWorkflowBoardView.KanbanWorkflowBoardUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management/kanban-workflow-board";
}
