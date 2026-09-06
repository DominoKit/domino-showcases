package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.DataQualityScorecardView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.DataQualityScorecardSample;

@UiView
public class DataQualityScorecardViewImpl extends SamplePageView<DataQualityScorecardView.DataQualityScorecardUiHandlers>
    implements DataQualityScorecardView {

  @Inject
  public DataQualityScorecardViewImpl() {
    super("Data quality scorecard", "Layout: Quality dimensions, scores, trend charts, failing rules, and affected records are shown together. Interaction: Users drill into failures, assign remediation, acknowledge exceptions, and re-run checks. Variants: Dataset scorecard, domain scorecard, or executive summary.");
    addSample("Data quality scorecard", "Layout: Quality dimensions, scores, trend charts, failing rules, and affected records are shown together. Interaction: Users drill into failures, assign remediation, acknowledge exceptions, and re-run checks. Variants: Dataset scorecard, domain scorecard, or executive summary.", DataQualityScorecardSample.class, DataQualityScorecardSample::create);
    initPage();
  }
}
