package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ReportBuilderSample {

  private ReportBuilderSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Report builder",
        "Layout: Fields, dimensions, measures, filters, and a preview table/chart occupy structured panels. Interaction: Users compose a report, reorder fields, preview results, save, and share it. Variants: Guided builder, drag-and-drop builder, or query-first builder.",
        BlueprintSampleKind.REPORT,
        "Fields, dimensions, measures, filters, and a preview table/chart occupy structured panels.", "Users compose a report, reorder fields, preview results, save, and share it.");
  }
}
