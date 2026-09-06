package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.TimeSeriesAnalysisScreenView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.TimeSeriesAnalysisScreenSample;

@UiView
public class TimeSeriesAnalysisScreenViewImpl extends BlueprintSamplePageView<TimeSeriesAnalysisScreenView.TimeSeriesAnalysisScreenUiHandlers>
    implements TimeSeriesAnalysisScreenView {

  @Inject
  public TimeSeriesAnalysisScreenViewImpl() {
    super("Time-series analysis screen", "Layout: Date controls, trend chart, comparison selector, and event markers form the page hierarchy. Interaction: Users zoom, compare periods, toggle series, and inspect data points. Variants: Single metric, multi-metric, or anomaly-focused analysis.");
    addSample("Time-series analysis screen", "Layout: Date controls, trend chart, comparison selector, and event markers form the page hierarchy. Interaction: Users zoom, compare periods, toggle series, and inspect data points. Variants: Single metric, multi-metric, or anomaly-focused analysis.", TimeSeriesAnalysisScreenSample.class, TimeSeriesAnalysisScreenSample::create);
    initPage();
  }
}
