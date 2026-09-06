package org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class MetricDefinitionAndGovernanceScreenSample {

  private MetricDefinitionAndGovernanceScreenSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Metric definition and governance screen",
        "Layout: Metric metadata, formula, owner, lineage, thresholds, and usage references are grouped into tabs or sections. Interaction: Users edit definitions, validate formulas, approve changes, and inspect dependencies. Variants: Business glossary, KPI registry, or data catalog metric page.",
        BlueprintSampleKind.REPORT,
        "Metric metadata, formula, owner, lineage, thresholds, and usage references are grouped into tabs or sections.", "Users edit definitions, validate formulas, approve changes, and inspect dependencies.");
  }
}
