package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.AlertTriageScreenView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.AlertTriageScreenSample;

@UiView
public class AlertTriageScreenViewImpl extends SamplePageView<AlertTriageScreenView.AlertTriageScreenUiHandlers>
    implements AlertTriageScreenView {

  @Inject
  public AlertTriageScreenViewImpl() {
    super("Alert triage screen", "Layout: Alert queue with severity, source, age, owner, and a detail/evidence panel. Interaction: Users acknowledge, suppress, group, assign, escalate, and resolve alerts. Variants: Security, infrastructure, business-rule, or data-quality alerts.");
    addSample("Alert triage screen", "Layout: Alert queue with severity, source, age, owner, and a detail/evidence panel. Interaction: Users acknowledge, suppress, group, assign, escalate, and resolve alerts. Variants: Security, infrastructure, business-rule, or data-quality alerts.", AlertTriageScreenSample.class, AlertTriageScreenSample::create);
    initPage();
  }
}
