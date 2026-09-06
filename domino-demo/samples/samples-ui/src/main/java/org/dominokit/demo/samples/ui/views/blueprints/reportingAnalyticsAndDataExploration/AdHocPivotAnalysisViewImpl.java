package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.AdHocPivotAnalysisView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.AdHocPivotAnalysisSample;

@UiView
public class AdHocPivotAnalysisViewImpl extends BlueprintSamplePageView<AdHocPivotAnalysisView.AdHocPivotAnalysisUiHandlers>
    implements AdHocPivotAnalysisView {

  @Inject
  public AdHocPivotAnalysisViewImpl() {
    super("Ad hoc pivot analysis", "Layout: Pivot configuration controls accompany a pivot table or chart. Interaction: Users drag dimensions/measures, expand groups, filter values, and export the result. Variants: Table-first, chart-first, or saved analysis workspace.");
    addSample("Ad hoc pivot analysis", "Layout: Pivot configuration controls accompany a pivot table or chart. Interaction: Users drag dimensions/measures, expand groups, filter values, and export the result. Variants: Table-first, chart-first, or saved analysis workspace.", AdHocPivotAnalysisSample.class, AdHocPivotAnalysisSample::create);
    initPage();
  }
}
