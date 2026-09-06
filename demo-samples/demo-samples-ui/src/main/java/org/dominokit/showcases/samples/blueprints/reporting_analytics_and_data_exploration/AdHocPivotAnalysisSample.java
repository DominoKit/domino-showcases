package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class AdHocPivotAnalysisSample {

  private AdHocPivotAnalysisSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Ad hoc pivot analysis",
        "Layout: Pivot configuration controls accompany a pivot table or chart. Interaction: Users drag dimensions/measures, expand groups, filter values, and export the result. Variants: Table-first, chart-first, or saved analysis workspace.",
        BlueprintSampleKind.REPORT,
        "Pivot configuration controls accompany a pivot table or chart.", "Users drag dimensions/measures, expand groups, filter values, and export the result.");
  }
}
