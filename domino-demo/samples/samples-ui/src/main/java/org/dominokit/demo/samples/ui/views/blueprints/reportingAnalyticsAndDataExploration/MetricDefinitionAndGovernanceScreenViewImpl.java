package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.MetricDefinitionAndGovernanceScreenView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.MetricDefinitionAndGovernanceScreenSample;

@UiView
public class MetricDefinitionAndGovernanceScreenViewImpl extends BlueprintSamplePageView<MetricDefinitionAndGovernanceScreenView.MetricDefinitionAndGovernanceScreenUiHandlers>
    implements MetricDefinitionAndGovernanceScreenView {

  @Inject
  public MetricDefinitionAndGovernanceScreenViewImpl() {
    super("Metric definition and governance screen", "Layout: Metric metadata, formula, owner, lineage, thresholds, and usage references are grouped into tabs or sections. Interaction: Users edit definitions, validate formulas, approve changes, and inspect dependencies. Variants: Business glossary, KPI registry, or data catalog metric page.");
    addSample("Metric definition and governance screen", "Layout: Metric metadata, formula, owner, lineage, thresholds, and usage references are grouped into tabs or sections. Interaction: Users edit definitions, validate formulas, approve changes, and inspect dependencies. Variants: Business glossary, KPI registry, or data catalog metric page.", MetricDefinitionAndGovernanceScreenSample.class, MetricDefinitionAndGovernanceScreenSample::create);
    initPage();
  }
}
