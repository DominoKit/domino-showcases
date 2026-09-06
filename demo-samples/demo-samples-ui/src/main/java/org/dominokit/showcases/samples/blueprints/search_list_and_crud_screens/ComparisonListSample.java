package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ComparisonListSample {

  private ComparisonListSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Comparison list",
        "Layout: Results list includes selection controls and a comparison tray or compare button. Interaction: Users select a bounded number of records and compare shared fields side by side. Variants: Product comparison, policy comparison, or before/after version comparison.",
        BlueprintSampleKind.CRUD,
        "Results list includes selection controls and a comparison tray or compare button.", "Users select a bounded number of records and compare shared fields side by side.");
  }
}
