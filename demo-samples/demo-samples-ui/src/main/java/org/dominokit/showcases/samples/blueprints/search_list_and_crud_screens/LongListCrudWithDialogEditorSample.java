package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class LongListCrudWithDialogEditorSample {

  private LongListCrudWithDialogEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Long-list CRUD with dialog editor",
        "Layout: Toolbar, persistent filters, paginated or virtualized table, and modal editor for add/edit. Interaction: Users navigate pages, apply filters, perform row actions, and edit one record at a time in a dialog. Variants: Server-side search, bulk selection, or side-panel editor instead of modal.",
        BlueprintSampleKind.CRUD,
        "Toolbar, persistent filters, paginated or virtualized table, and modal editor for add/edit.", "Users navigate pages, apply filters, perform row actions, and edit one record at a time in a dialog.");
  }
}
