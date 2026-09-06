package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ShortListCrudWithDialogEditorSample {

  private ShortListCrudWithDialogEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Short-list CRUD with dialog editor",
        "Layout: Page header, compact filter row, short table/list, and a primary add button; add/edit opens a modal dialog. Interaction: Users search, sort, add, edit, delete, and confirm changes without leaving the list. Variants: Confirm-before-delete, optimistic updates, or wizard dialog for complex records.",
        BlueprintSampleKind.CRUD,
        "Page header, compact filter row, short table/list, and a primary add button; add/edit opens a modal dialog.", "Users search, sort, add, edit, delete, and confirm changes without leaving the list.");
  }
}
