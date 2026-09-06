package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.GeographicMapAnalyticsScreenView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.GeographicMapAnalyticsScreenSample;

@UiView
public class GeographicMapAnalyticsScreenViewImpl extends BlueprintSamplePageView<GeographicMapAnalyticsScreenView.GeographicMapAnalyticsScreenUiHandlers>
    implements GeographicMapAnalyticsScreenView {

  @Inject
  public GeographicMapAnalyticsScreenViewImpl() {
    super("Geographic/map analytics screen", "Layout: Map or spatial canvas is paired with filters, legend, and a result/detail panel. Interaction: Users pan, zoom, select regions/markers, filter categories, and open records. Variants: Marker map, choropleth, route map, or map/list split.");
    addSample("Geographic/map analytics screen", "Layout: Map or spatial canvas is paired with filters, legend, and a result/detail panel. Interaction: Users pan, zoom, select regions/markers, filter categories, and open records. Variants: Marker map, choropleth, route map, or map/list split.", GeographicMapAnalyticsScreenSample.class, GeographicMapAnalyticsScreenSample::create);
    initPage();
  }
}
