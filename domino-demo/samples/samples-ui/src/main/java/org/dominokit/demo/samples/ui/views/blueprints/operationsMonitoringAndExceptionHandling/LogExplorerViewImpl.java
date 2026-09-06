package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.LogExplorerView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.LogExplorerSample;

@UiView
public class LogExplorerViewImpl extends SamplePageView<LogExplorerView.LogExplorerUiHandlers>
    implements LogExplorerView {

  @Inject
  public LogExplorerViewImpl() {
    super("Log explorer", "Layout: Query/filter bar, time-series summary, log stream, and selected-entry detail. Interaction: Users search, refine queries, expand context, bookmark queries, and export results. Variants: Structured logs, application logs, or audit events.");
    addSample("Log explorer", "Layout: Query/filter bar, time-series summary, log stream, and selected-entry detail. Interaction: Users search, refine queries, expand context, bookmark queries, and export results. Variants: Structured logs, application logs, or audit events.", LogExplorerSample.class, LogExplorerSample::create);
    initPage();
  }
}
