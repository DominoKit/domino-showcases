package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ListWithBulkActionToolbarSample {

  private ListWithBulkActionToolbarSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "List with bulk action toolbar",
        "Layout: Selectable rows/cards and a toolbar that appears or changes when selection exists. Interaction: Users select individual/all records, apply a bulk operation, review impact, and confirm. Variants: Bulk edit, assign, archive, export, tag, or status transition.",
        BlueprintSampleKind.CRUD,
        "Selectable rows/cards and a toolbar that appears or changes when selection exists.", "Users select individual/all records, apply a bulk operation, review impact, and confirm.");
  }
}
