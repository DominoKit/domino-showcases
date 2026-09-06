package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class JobAndBatchMonitorSample {

  private JobAndBatchMonitorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Job and batch monitor",
        "Layout: Job list with status, schedule, duration, logs, retries, and run detail. Interaction: Users start, pause, retry, cancel, inspect logs, and compare runs. Variants: ETL jobs, scheduled reports, or background processing.",
        BlueprintSampleKind.OPERATIONS,
        "Job list with status, schedule, duration, logs, retries, and run detail.", "Users start, pause, retry, cancel, inspect logs, and compare runs.");
  }
}
