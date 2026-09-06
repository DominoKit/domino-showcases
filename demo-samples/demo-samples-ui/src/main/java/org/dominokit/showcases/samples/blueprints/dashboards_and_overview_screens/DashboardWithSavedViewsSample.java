package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DashboardWithSavedViewsSample {

  private DashboardWithSavedViewsSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Dashboard with saved views",
        "Layout: Dashboard content is controlled by a saved-view selector beside filters and date controls. Interaction: Users apply, save, rename, share, or delete dashboard configurations. Variants: Personal-only views, team-shared views, or role-enforced defaults.",
        BlueprintSampleKind.DASHBOARD,
        "Dashboard content is controlled by a saved-view selector beside filters and date controls.", "Users apply, save, rename, share, or delete dashboard configurations.");
  }
}
