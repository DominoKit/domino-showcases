package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.SlaAndEscalationMonitorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SlaAndEscalationMonitorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SlaAndEscalationMonitorPresenter extends ChildPresenter<ShellPresenter, SlaAndEscalationMonitorView>
    implements SlaAndEscalationMonitorView.SlaAndEscalationMonitorUiHandlers {

  public static final String ROUTE = "blueprints/workflow-approvals-and-task-management/sla-and-escalation-monitor";
}
