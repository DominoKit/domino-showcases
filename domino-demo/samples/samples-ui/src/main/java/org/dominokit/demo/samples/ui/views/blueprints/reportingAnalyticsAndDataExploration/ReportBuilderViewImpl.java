package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ReportBuilderView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.ReportBuilderSample;

@UiView
public class ReportBuilderViewImpl extends SamplePageView<ReportBuilderView.ReportBuilderUiHandlers>
    implements ReportBuilderView {

  @Inject
  public ReportBuilderViewImpl() {
    super("Report builder", "Layout: Fields, dimensions, measures, filters, and a preview table/chart occupy structured panels. Interaction: Users compose a report, reorder fields, preview results, save, and share it. Variants: Guided builder, drag-and-drop builder, or query-first builder.");
    addSample("Report builder", "Layout: Fields, dimensions, measures, filters, and a preview table/chart occupy structured panels. Interaction: Users compose a report, reorder fields, preview results, save, and share it. Variants: Guided builder, drag-and-drop builder, or query-first builder.", ReportBuilderSample.class, ReportBuilderSample::create);
    initPage();
  }
}
