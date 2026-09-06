package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class IncidentManagementWorkspaceSample {

  private IncidentManagementWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Incident management workspace",
        "Layout: Incident header, severity/status, timeline, responders, communication log, and action checklist. Interaction: Responders assign roles, update status, add events, publish updates, and resolve/postmortem. Variants: War-room view, incident detail, or command-center split view.",
        BlueprintSampleKind.OPERATIONS,
        "Incident header, severity/status, timeline, responders, communication log, and action checklist.", "Responders assign roles, update status, add events, publish updates, and resolve/postmortem.");
  }
}
