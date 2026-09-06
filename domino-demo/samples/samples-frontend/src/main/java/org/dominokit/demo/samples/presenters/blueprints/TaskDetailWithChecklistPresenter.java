package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.TaskDetailWithChecklistView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TaskDetailWithChecklistPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TaskDetailWithChecklistPresenter extends ChildPresenter<ShellPresenter, TaskDetailWithChecklistView>
    implements TaskDetailWithChecklistView.TaskDetailWithChecklistUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management/task-detail-with-checklist";
}
