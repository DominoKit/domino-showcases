package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ReportViewerWithParameterBarView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.ReportViewerWithParameterBarSample;

@UiView
public class ReportViewerWithParameterBarViewImpl extends BlueprintSamplePageView<ReportViewerWithParameterBarView.ReportViewerWithParameterBarUiHandlers>
    implements ReportViewerWithParameterBarView {

  @Inject
  public ReportViewerWithParameterBarViewImpl() {
    super("Report viewer with parameter bar", "Layout: Report title and parameter controls sit above a generated report surface. Interaction: Users set parameters, run, refresh, export, print, and save the report. Variants: Synchronous run, queued run, or paginated report viewer.");
    addSample("Report viewer with parameter bar", "Layout: Report title and parameter controls sit above a generated report surface. Interaction: Users set parameters, run, refresh, export, print, and save the report. Variants: Synchronous run, queued run, or paginated report viewer.", ReportViewerWithParameterBarSample.class, ReportViewerWithParameterBarSample::create);
    initPage();
  }
}
