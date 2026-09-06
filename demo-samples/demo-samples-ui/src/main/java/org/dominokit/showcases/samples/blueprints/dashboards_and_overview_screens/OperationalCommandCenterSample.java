package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class OperationalCommandCenterSample {

  private OperationalCommandCenterSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Operational command center",
        "Layout: Dense summary strip, alerts, live status panels, trend charts, and an active-work queue. Interaction: Users monitor changing conditions, acknowledge alerts, filter by severity, and jump to remediation screens. Variants: Auto-refresh, wallboard mode, or manually refreshed snapshot.",
        BlueprintSampleKind.DASHBOARD,
        "Dense summary strip, alerts, live status panels, trend charts, and an active-work queue.", "Users monitor changing conditions, acknowledge alerts, filter by severity, and jump to remediation screens.");
  }
}
