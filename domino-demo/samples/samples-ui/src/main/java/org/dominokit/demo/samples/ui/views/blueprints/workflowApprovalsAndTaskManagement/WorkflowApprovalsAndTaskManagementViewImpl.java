package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.WorkflowApprovalsAndTaskManagementView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.PersonalTaskInboxSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.TeamWorkQueueSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.ApprovalRequestScreenSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.ApprovalMatrixConfigurationSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.CaseManagementWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.KanbanWorkflowBoardSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.WorkflowTimelineAndMilestoneViewSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.ExceptionReviewQueueSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.SlaAndEscalationMonitorSample;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.TaskDetailWithChecklistSample;

@UiView
public class WorkflowApprovalsAndTaskManagementViewImpl extends BrixView<HTMLDivElement, WorkflowApprovalsAndTaskManagementView.WorkflowApprovalsAndTaskManagementUiHandlers>
    implements WorkflowApprovalsAndTaskManagementView {

  private final DivElement root;

  @Inject
  public WorkflowApprovalsAndTaskManagementViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Workflow, approvals, and task management",
            "Catalog category with 10 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Personal task inbox",
                    "Layout: Prioritized task list with status filters and a task detail pane or page. Interaction: Users claim, complete, delegate, snooze, or reject tasks. Variants: List-detail split, grouped by due date, or grouped by process.",
                    PersonalTaskInboxSample.class,
                    PersonalTaskInboxSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Team work queue",
                    "Layout: Queue table includes ownership, priority, age, SLA, and status columns. Interaction: Users assign, reassign, claim, bulk-update, and open work items. Variants: Round-robin queue, skill-based queue, or supervisor view.",
                    TeamWorkQueueSample.class,
                    TeamWorkQueueSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Approval request screen",
                    "Layout: Request summary, submitted values, supporting evidence, decision controls, and history. Interaction: Reviewers approve, reject, request changes, delegate, or add comments. Variants: Single approver, sequential approval chain, or parallel approvals.",
                    ApprovalRequestScreenSample.class,
                    ApprovalRequestScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Approval matrix configuration",
                    "Layout: Rules, thresholds, roles, and escalation paths are shown in a structured editor. Interaction: Administrators add conditions, order approvers, test a rule, and publish changes. Variants: Table editor, visual rule builder, or nested policy editor.",
                    ApprovalMatrixConfigurationSample.class,
                    ApprovalMatrixConfigurationSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Case management workspace",
                    "Layout: Case header, status/priority summary, customer or subject details, activity timeline, tasks, and related records. Interaction: Users update status, assign owners, add notes, attach evidence, and resolve/escalate. Variants: Support case, compliance case, incident case, or investigation case.",
                    CaseManagementWorkspaceSample.class,
                    CaseManagementWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Kanban workflow board",
                    "Layout: Columns represent workflow states and cards represent work items. Interaction: Users drag cards between states, open details, assign owners, and filter the board. Variants: WIP limits, swimlanes, card grouping, or keyboard-accessible movement.",
                    KanbanWorkflowBoardSample.class,
                    KanbanWorkflowBoardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Workflow timeline and milestone view",
                    "Layout: Process stages appear along a timeline with current state, owners, dates, and blockers. Interaction: Users open milestones, complete transitions, add evidence, and inspect history. Variants: Horizontal timeline, vertical timeline, or timeline plus task list.",
                    WorkflowTimelineAndMilestoneViewSample.class,
                    WorkflowTimelineAndMilestoneViewSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Exception review queue",
                    "Layout: Failed, suspicious, or incomplete items appear in a queue with reason and severity. Interaction: Users inspect evidence, correct data, retry processing, suppress, or escalate. Variants: Batch exception review, fraud review, or integration error queue.",
                    ExceptionReviewQueueSample.class,
                    ExceptionReviewQueueSample::create))
            .appendChild(
                SampleShowcase.create(
                    "SLA and escalation monitor",
                    "Layout: Aging buckets, SLA indicators, breached items, and escalation controls summarize work health. Interaction: Users filter by risk, reassign work, extend deadlines with reason, and open the underlying item. Variants: Real-time monitor, daily management report, or team dashboard.",
                    SlaAndEscalationMonitorSample.class,
                    SlaAndEscalationMonitorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Task detail with checklist",
                    "Layout: Task description and owner information are paired with a required/optional checklist and completion evidence. Interaction: Users check items, attach evidence, comment, and complete or return the task. Variants: Inspection checklist, onboarding checklist, or maintenance checklist.",
                    TaskDetailWithChecklistSample.class,
                    TaskDetailWithChecklistSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
