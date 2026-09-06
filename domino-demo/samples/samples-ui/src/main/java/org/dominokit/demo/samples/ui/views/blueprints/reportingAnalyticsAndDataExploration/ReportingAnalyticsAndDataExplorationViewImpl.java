package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ReportingAnalyticsAndDataExplorationView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.ReportViewerWithParameterBarSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.ReportBuilderSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.AdHocPivotAnalysisSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.TimeSeriesAnalysisScreenSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.GeographicMapAnalyticsScreenSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.MetricDefinitionAndGovernanceScreenSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.ScheduledReportManagementSample;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.DataQualityScorecardSample;

@UiView
public class ReportingAnalyticsAndDataExplorationViewImpl extends BrixView<HTMLDivElement, ReportingAnalyticsAndDataExplorationView.ReportingAnalyticsAndDataExplorationUiHandlers>
    implements ReportingAnalyticsAndDataExplorationView {

  private final DivElement root;

  @Inject
  public ReportingAnalyticsAndDataExplorationViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Reporting, analytics, and data exploration",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Report viewer with parameter bar",
                    "Layout: Report title and parameter controls sit above a generated report surface. Interaction: Users set parameters, run, refresh, export, print, and save the report. Variants: Synchronous run, queued run, or paginated report viewer.",
                    ReportViewerWithParameterBarSample.class,
                    ReportViewerWithParameterBarSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Report builder",
                    "Layout: Fields, dimensions, measures, filters, and a preview table/chart occupy structured panels. Interaction: Users compose a report, reorder fields, preview results, save, and share it. Variants: Guided builder, drag-and-drop builder, or query-first builder.",
                    ReportBuilderSample.class,
                    ReportBuilderSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Ad hoc pivot analysis",
                    "Layout: Pivot configuration controls accompany a pivot table or chart. Interaction: Users drag dimensions/measures, expand groups, filter values, and export the result. Variants: Table-first, chart-first, or saved analysis workspace.",
                    AdHocPivotAnalysisSample.class,
                    AdHocPivotAnalysisSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Time-series analysis screen",
                    "Layout: Date controls, trend chart, comparison selector, and event markers form the page hierarchy. Interaction: Users zoom, compare periods, toggle series, and inspect data points. Variants: Single metric, multi-metric, or anomaly-focused analysis.",
                    TimeSeriesAnalysisScreenSample.class,
                    TimeSeriesAnalysisScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Geographic/map analytics screen",
                    "Layout: Map or spatial canvas is paired with filters, legend, and a result/detail panel. Interaction: Users pan, zoom, select regions/markers, filter categories, and open records. Variants: Marker map, choropleth, route map, or map/list split.",
                    GeographicMapAnalyticsScreenSample.class,
                    GeographicMapAnalyticsScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Metric definition and governance screen",
                    "Layout: Metric metadata, formula, owner, lineage, thresholds, and usage references are grouped into tabs or sections. Interaction: Users edit definitions, validate formulas, approve changes, and inspect dependencies. Variants: Business glossary, KPI registry, or data catalog metric page.",
                    MetricDefinitionAndGovernanceScreenSample.class,
                    MetricDefinitionAndGovernanceScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Scheduled report management",
                    "Layout: Report list includes schedule, recipients, delivery status, and last-run information. Interaction: Users create, pause, edit, test, duplicate, and monitor scheduled deliveries. Variants: Email delivery, file drop, dashboard refresh, or webhook delivery.",
                    ScheduledReportManagementSample.class,
                    ScheduledReportManagementSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Data quality scorecard",
                    "Layout: Quality dimensions, scores, trend charts, failing rules, and affected records are shown together. Interaction: Users drill into failures, assign remediation, acknowledge exceptions, and re-run checks. Variants: Dataset scorecard, domain scorecard, or executive summary.",
                    DataQualityScorecardSample.class,
                    DataQualityScorecardSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
