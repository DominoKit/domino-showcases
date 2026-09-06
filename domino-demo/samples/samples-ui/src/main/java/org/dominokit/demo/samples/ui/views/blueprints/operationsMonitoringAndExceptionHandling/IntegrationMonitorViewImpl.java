package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.IntegrationMonitorView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.IntegrationMonitorSample;

@UiView
public class IntegrationMonitorViewImpl extends BlueprintSamplePageView<IntegrationMonitorView.IntegrationMonitorUiHandlers>
    implements IntegrationMonitorView {

  @Inject
  public IntegrationMonitorViewImpl() {
    super("Integration monitor", "Layout: Integration endpoints, message counts, latency, failures, and recent payloads appear in a monitoring workspace. Interaction: Users inspect failures, replay messages, pause/resume endpoints, and test connections. Variants: API integration, event stream, or file exchange.");
    addSample("Integration monitor", "Layout: Integration endpoints, message counts, latency, failures, and recent payloads appear in a monitoring workspace. Interaction: Users inspect failures, replay messages, pause/resume endpoints, and test connections. Variants: API integration, event stream, or file exchange.", IntegrationMonitorSample.class, IntegrationMonitorSample::create);
    initPage();
  }
}
