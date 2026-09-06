package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.PersonalTaskInboxView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(PersonalTaskInboxPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class PersonalTaskInboxPresenter extends ChildPresenter<ShellPresenter, PersonalTaskInboxView>
    implements PersonalTaskInboxView.PersonalTaskInboxUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management/personal-task-inbox";
}
