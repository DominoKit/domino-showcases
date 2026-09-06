package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class IntegrationMonitorSample {

  private IntegrationMonitorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Integration monitor",
        "Layout: Integration endpoints, message counts, latency, failures, and recent payloads appear in a monitoring workspace. Interaction: Users inspect failures, replay messages, pause/resume endpoints, and test connections. Variants: API integration, event stream, or file exchange.",
        BlueprintSampleKind.OPERATIONS,
        "Integration endpoints, message counts, latency, failures, and recent payloads appear in a monitoring workspace.", "Users inspect failures, replay messages, pause/resume endpoints, and test connections.");
  }
}
