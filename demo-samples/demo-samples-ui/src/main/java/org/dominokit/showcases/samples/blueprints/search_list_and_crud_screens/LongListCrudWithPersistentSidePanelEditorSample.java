package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class LongListCrudWithPersistentSidePanelEditorSample {

  private LongListCrudWithPersistentSidePanelEditorSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Long-list CRUD with persistent side-panel editor",
        "Layout: Dense list occupies the main region while a right-side editor opens without removing the list. Interaction: Users select a row, edit it in context, save, and continue to another row. Variants: Resizable panel, read-only preview before edit, or stacked mobile drawer.",
        BlueprintSampleKind.CRUD,
        "Dense list occupies the main region while a right-side editor opens without removing the list.", "Users select a row, edit it in context, save, and continue to another row.");
  }
}
