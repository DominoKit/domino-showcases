package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class LogExplorerSample {

  private LogExplorerSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Log explorer",
        "Layout: Query/filter bar, time-series summary, log stream, and selected-entry detail. Interaction: Users search, refine queries, expand context, bookmark queries, and export results. Variants: Structured logs, application logs, or audit events.",
        BlueprintSampleKind.OPERATIONS,
        "Query/filter bar, time-series summary, log stream, and selected-entry detail.", "Users search, refine queries, expand context, bookmark queries, and export results.");
  }
}
