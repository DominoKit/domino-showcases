package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class TimeSeriesAnalysisScreenSample {

  private TimeSeriesAnalysisScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Time-series analysis screen",
        "Layout: Date controls, trend chart, comparison selector, and event markers form the page hierarchy. Interaction: Users zoom, compare periods, toggle series, and inspect data points. Variants: Single metric, multi-metric, or anomaly-focused analysis.",
        BlueprintSampleKind.REPORT,
        "Date controls, trend chart, comparison selector, and event markers form the page hierarchy.", "Users zoom, compare periods, toggle series, and inspect data points.");
  }
}
