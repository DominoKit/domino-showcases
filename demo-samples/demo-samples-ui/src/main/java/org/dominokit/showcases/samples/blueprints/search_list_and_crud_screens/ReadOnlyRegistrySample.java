package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ReadOnlyRegistrySample {

  private ReadOnlyRegistrySample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Read-only registry",
        "Layout: Search/filter toolbar and a dense data table with no mutation controls. Interaction: Users inspect, sort, export, and open a read-only detail view. Variants: Audit registry, public directory, historical snapshot, or print-oriented layout.",
        BlueprintSampleKind.CRUD,
        "Search/filter toolbar and a dense data table with no mutation controls.", "Users inspect, sort, export, and open a read-only detail view.");
  }
}
