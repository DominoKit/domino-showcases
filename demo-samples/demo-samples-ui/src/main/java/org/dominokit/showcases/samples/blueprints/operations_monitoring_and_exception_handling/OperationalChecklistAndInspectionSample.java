package org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class OperationalChecklistAndInspectionSample {

  private OperationalChecklistAndInspectionSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Operational checklist and inspection",
        "Layout: Asset/location summary, checklist sections, measurements, evidence, and sign-off area. Interaction: Users complete checks, record exceptions, attach photos/files, and sign or escalate. Variants: Field inspection, safety inspection, or opening/closing checklist.",
        BlueprintSampleKind.OPERATIONS,
        "Asset/location summary, checklist sections, measurements, evidence, and sign-off area.", "Users complete checks, record exceptions, attach photos/files, and sign or escalate.");
  }
}
