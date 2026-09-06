package org.dominokit.showcases.samples.blueprints.application_foundations_and_navigation;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class BreadcrumbAndBackStackWorkspaceSample {

  private BreadcrumbAndBackStackWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Breadcrumb and back-stack workspace",
        "Layout: A compact breadcrumb and back control sit above content, with no permanent side navigation required. Interaction: Users traverse nested records and return to prior contexts without rebuilding the full search state. Variants: Breadcrumb-only, breadcrumb plus history menu, or breadcrumb plus split view.",
        BlueprintSampleKind.NAVIGATION,
        "A compact breadcrumb and back control sit above content, with no permanent side navigation required.", "Users traverse nested records and return to prior contexts without rebuilding the full search state.");
  }
}
