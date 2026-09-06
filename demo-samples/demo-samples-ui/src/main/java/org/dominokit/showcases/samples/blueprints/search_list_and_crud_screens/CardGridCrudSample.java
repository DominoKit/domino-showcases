package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class CardGridCrudSample {

  private CardGridCrudSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Card-grid CRUD",
        "Layout: Toolbar and filters lead into cards with summary fields, status, and action menu. Interaction: Users open, edit, archive, duplicate, or delete a card, with add handled by a dialog or form page. Variants: Kanban-like cards, image-heavy cards, or responsive grid/list toggle.",
        BlueprintSampleKind.CRUD,
        "Toolbar and filters lead into cards with summary fields, status, and action menu.", "Users open, edit, archive, duplicate, or delete a card, with add handled by a dialog or form page.");
  }
}
