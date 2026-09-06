package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.TransactionReconciliationScreenView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.TransactionReconciliationScreenSample;

@UiView
public class TransactionReconciliationScreenViewImpl extends SamplePageView<TransactionReconciliationScreenView.TransactionReconciliationScreenUiHandlers>
    implements TransactionReconciliationScreenView {

  @Inject
  public TransactionReconciliationScreenViewImpl() {
    super("Transaction reconciliation screen", "Layout: Matched, unmatched, and exception records are grouped with amount/date/reference summaries. Interaction: Users match records, split/merge candidates, accept differences, and post adjustments. Variants: Bank reconciliation, inventory reconciliation, or integration reconciliation.");
    addSample("Transaction reconciliation screen", "Layout: Matched, unmatched, and exception records are grouped with amount/date/reference summaries. Interaction: Users match records, split/merge candidates, accept differences, and post adjustments. Variants: Bank reconciliation, inventory reconciliation, or integration reconciliation.", TransactionReconciliationScreenSample.class, TransactionReconciliationScreenSample::create);
    initPage();
  }
}
