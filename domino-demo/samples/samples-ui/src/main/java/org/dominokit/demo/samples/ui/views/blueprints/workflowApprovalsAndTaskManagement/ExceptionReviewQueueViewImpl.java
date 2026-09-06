package org.dominokit.demo.samples.ui.views.blueprints.workflowApprovalsAndTaskManagement;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.workflowApprovalsAndTaskManagement.ExceptionReviewQueueView;
import org.dominokit.showcases.samples.blueprints.workflow_approvals_and_task_management.ExceptionReviewQueueSample;

@UiView
public class ExceptionReviewQueueViewImpl extends SamplePageView<ExceptionReviewQueueView.ExceptionReviewQueueUiHandlers>
    implements ExceptionReviewQueueView {

  @Inject
  public ExceptionReviewQueueViewImpl() {
    super("Exception review queue", "Layout: Failed, suspicious, or incomplete items appear in a queue with reason and severity. Interaction: Users inspect evidence, correct data, retry processing, suppress, or escalate. Variants: Batch exception review, fraud review, or integration error queue.");
    addSample("Exception review queue", "Layout: Failed, suspicious, or incomplete items appear in a queue with reason and severity. Interaction: Users inspect evidence, correct data, retry processing, suppress, or escalate. Variants: Batch exception review, fraud review, or integration error queue.", ExceptionReviewQueueSample.class, ExceptionReviewQueueSample::create);
    initPage();
  }
}
