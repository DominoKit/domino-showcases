package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DataQualityScorecardSample {

  private DataQualityScorecardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Data quality scorecard",
        "Layout: Quality dimensions, scores, trend charts, failing rules, and affected records are shown together. Interaction: Users drill into failures, assign remediation, acknowledge exceptions, and re-run checks. Variants: Dataset scorecard, domain scorecard, or executive summary.",
        BlueprintSampleKind.REPORT,
        "Quality dimensions, scores, trend charts, failing rules, and affected records are shown together.", "Users drill into failures, assign remediation, acknowledge exceptions, and re-run checks.");
  }
}
