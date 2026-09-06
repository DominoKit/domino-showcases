package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ReportViewerWithParameterBarSample {

  private ReportViewerWithParameterBarSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Report viewer with parameter bar",
        "Layout: Report title and parameter controls sit above a generated report surface. Interaction: Users set parameters, run, refresh, export, print, and save the report. Variants: Synchronous run, queued run, or paginated report viewer.",
        BlueprintSampleKind.REPORT,
        "Report title and parameter controls sit above a generated report surface.", "Users set parameters, run, refresh, export, print, and save the report.");
  }
}
