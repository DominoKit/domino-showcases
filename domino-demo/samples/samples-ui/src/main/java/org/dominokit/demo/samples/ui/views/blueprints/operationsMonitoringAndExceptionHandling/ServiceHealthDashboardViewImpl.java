package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.ServiceHealthDashboardView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.ServiceHealthDashboardSample;

@UiView
public class ServiceHealthDashboardViewImpl extends SamplePageView<ServiceHealthDashboardView.ServiceHealthDashboardUiHandlers>
    implements ServiceHealthDashboardView {

  @Inject
  public ServiceHealthDashboardViewImpl() {
    super("Service health dashboard", "Layout: Service status cards, dependency map, incidents, latency/error charts, and recent deploys. Interaction: Operators filter services, inspect incidents, acknowledge alerts, and open runbooks. Variants: Executive health, engineering operations, or tenant-specific health.");
    addSample("Service health dashboard", "Layout: Service status cards, dependency map, incidents, latency/error charts, and recent deploys. Interaction: Operators filter services, inspect incidents, acknowledge alerts, and open runbooks. Variants: Executive health, engineering operations, or tenant-specific health.", ServiceHealthDashboardSample.class, ServiceHealthDashboardSample::create);
    initPage();
  }
}
