package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.IncidentManagementWorkspaceView;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.IncidentManagementWorkspaceSample;

@UiView
public class IncidentManagementWorkspaceViewImpl extends SamplePageView<IncidentManagementWorkspaceView.IncidentManagementWorkspaceUiHandlers>
    implements IncidentManagementWorkspaceView {

  @Inject
  public IncidentManagementWorkspaceViewImpl() {
    super("Incident management workspace", "Layout: Incident header, severity/status, timeline, responders, communication log, and action checklist. Interaction: Responders assign roles, update status, add events, publish updates, and resolve/postmortem. Variants: War-room view, incident detail, or command-center split view.");
    addSample("Incident management workspace", "Layout: Incident header, severity/status, timeline, responders, communication log, and action checklist. Interaction: Responders assign roles, update status, add events, publish updates, and resolve/postmortem. Variants: War-room view, incident detail, or command-center split view.", IncidentManagementWorkspaceSample.class, IncidentManagementWorkspaceSample::create);
    initPage();
  }
}
