package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.KanbanWorkflowBoardView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.KanbanWorkflowBoardSample;

@UiView
public class KanbanWorkflowBoardViewImpl extends BlueprintSamplePageView<KanbanWorkflowBoardView.KanbanWorkflowBoardUiHandlers>
    implements KanbanWorkflowBoardView {

  @Inject
  public KanbanWorkflowBoardViewImpl() {
    super("Kanban workflow board", "Layout: Columns represent workflow states and cards represent work items. Interaction: Users drag cards between states, open details, assign owners, and filter the board. Variants: WIP limits, swimlanes, card grouping, or keyboard-accessible movement.");
    addSample("Kanban workflow board", "Layout: Columns represent workflow states and cards represent work items. Interaction: Users drag cards between states, open details, assign owners, and filter the board. Variants: WIP limits, swimlanes, card grouping, or keyboard-accessible movement.", KanbanWorkflowBoardSample.class, KanbanWorkflowBoardSample::create);
    initPage();
  }
}
