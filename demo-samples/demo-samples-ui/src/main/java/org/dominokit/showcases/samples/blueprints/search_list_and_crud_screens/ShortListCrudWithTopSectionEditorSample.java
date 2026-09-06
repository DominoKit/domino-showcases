package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ShortListCrudWithTopSectionEditorSample {

  private ShortListCrudWithTopSectionEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Short-list CRUD with top-section editor",
        "Layout: A form panel sits above a short list and is used for both add and edit. Interaction: Users select a row to load it into the form, save changes, clear the form, or start a new record. Variants: Always-visible form, collapsible form, or two-column form beside the list.",
        BlueprintSampleKind.CRUD,
        "A form panel sits above a short list and is used for both add and edit.", "Users select a row to load it into the form, save changes, clear the form, or start a new record.");
  }
}
