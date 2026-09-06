package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.JobAndBatchMonitorView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.JobAndBatchMonitorSample;

@UiView
public class JobAndBatchMonitorViewImpl extends BlueprintSamplePageView<JobAndBatchMonitorView.JobAndBatchMonitorUiHandlers>
    implements JobAndBatchMonitorView {

  @Inject
  public JobAndBatchMonitorViewImpl() {
    super("Job and batch monitor", "Layout: Job list with status, schedule, duration, logs, retries, and run detail. Interaction: Users start, pause, retry, cancel, inspect logs, and compare runs. Variants: ETL jobs, scheduled reports, or background processing.");
    addSample("Job and batch monitor", "Layout: Job list with status, schedule, duration, logs, retries, and run detail. Interaction: Users start, pause, retry, cancel, inspect logs, and compare runs. Variants: ETL jobs, scheduled reports, or background processing.", JobAndBatchMonitorSample.class, JobAndBatchMonitorSample::create);
    initPage();
  }
}
