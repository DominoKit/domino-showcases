package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ListWithRowExpansionSample {

  private ListWithRowExpansionSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "List with row expansion",
        "Layout: Compact list shows summary fields while expandable rows reveal secondary details. Interaction: Users expand one or several rows, perform row actions, and preserve expansion during sorting/filtering where possible. Variants: Nested table, inline timeline, or quick-edit expansion.",
        BlueprintSampleKind.CRUD,
        "Compact list shows summary fields while expandable rows reveal secondary details.", "Users expand one or several rows, perform row actions, and preserve expansion during sorting/filtering where possible.");
  }
}
