package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class TransactionReconciliationScreenSample {

  private TransactionReconciliationScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Transaction reconciliation screen",
        "Layout: Matched, unmatched, and exception records are grouped with amount/date/reference summaries. Interaction: Users match records, split/merge candidates, accept differences, and post adjustments. Variants: Bank reconciliation, inventory reconciliation, or integration reconciliation.",
        BlueprintSampleKind.OPERATIONS,
        "Matched, unmatched, and exception records are grouped with amount/date/reference summaries.", "Users match records, split/merge candidates, accept differences, and post adjustments.");
  }
}
