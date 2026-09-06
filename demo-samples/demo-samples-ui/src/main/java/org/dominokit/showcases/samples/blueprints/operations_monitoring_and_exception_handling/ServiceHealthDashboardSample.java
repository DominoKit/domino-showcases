package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ServiceHealthDashboardSample {

  private ServiceHealthDashboardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Service health dashboard",
        "Layout: Service status cards, dependency map, incidents, latency/error charts, and recent deploys. Interaction: Operators filter services, inspect incidents, acknowledge alerts, and open runbooks. Variants: Executive health, engineering operations, or tenant-specific health.",
        BlueprintSampleKind.OPERATIONS,
        "Service status cards, dependency map, incidents, latency/error charts, and recent deploys.", "Operators filter services, inspect incidents, acknowledge alerts, and open runbooks.");
  }
}
