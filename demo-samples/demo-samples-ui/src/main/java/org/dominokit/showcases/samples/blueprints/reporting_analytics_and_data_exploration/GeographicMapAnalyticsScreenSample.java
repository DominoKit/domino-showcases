package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class GeographicMapAnalyticsScreenSample {

  private GeographicMapAnalyticsScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Geographic/map analytics screen",
        "Layout: Map or spatial canvas is paired with filters, legend, and a result/detail panel. Interaction: Users pan, zoom, select regions/markers, filter categories, and open records. Variants: Marker map, choropleth, route map, or map/list split.",
        BlueprintSampleKind.REPORT,
        "Map or spatial canvas is paired with filters, legend, and a result/detail panel.", "Users pan, zoom, select regions/markers, filter categories, and open records.");
  }
}
