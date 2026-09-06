package org.dominokit.showcases.samples.blueprints.special_states_and_constrained_compositions;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ResponsiveDensityTransformationSample {

  private ResponsiveDensityTransformationSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Responsive density transformation",
        "Layout: Desktop table/panel composition transforms into cards, drawers, stacked sections, or prioritized fields on narrow screens. Interaction: Users retain the same task flow through mobile-friendly navigation and action placement. Variants: Table-to-card, split-to-drill-in, or toolbar-to-bottom-action-bar.",
        BlueprintSampleKind.STATE,
        "Desktop table/panel composition transforms into cards, drawers, stacked sections, or prioritized fields on narrow screens.", "Users retain the same task flow through mobile-friendly navigation and action placement.");
  }
}
