package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.ExceptionReviewQueueView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ExceptionReviewQueuePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ExceptionReviewQueuePresenter extends ChildPresenter<ShellPresenter, ExceptionReviewQueueView>
    implements ExceptionReviewQueueView.ExceptionReviewQueueUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management/exception-review-queue";
}
