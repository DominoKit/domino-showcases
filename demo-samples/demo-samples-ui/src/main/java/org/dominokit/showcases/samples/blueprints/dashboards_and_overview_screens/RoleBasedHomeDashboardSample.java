package org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class RoleBasedHomeDashboardSample {

  private RoleBasedHomeDashboardSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Role-based home dashboard",
        "Layout: Personalized welcome area followed by role-specific shortcuts, assigned work, recent records, and metrics. Interaction: Users resume work, customize widgets, and dismiss or pin content. Variants: Employee, manager, administrator, or external-partner home.",
        BlueprintSampleKind.DASHBOARD,
        "Personalized welcome area followed by role-specific shortcuts, assigned work, recent records, and metrics.", "Users resume work, customize widgets, and dismiss or pin content.");
  }
}
