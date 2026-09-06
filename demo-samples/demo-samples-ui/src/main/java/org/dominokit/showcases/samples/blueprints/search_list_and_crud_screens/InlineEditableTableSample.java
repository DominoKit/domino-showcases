package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class InlineEditableTableSample {

  private InlineEditableTableSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Inline-editable table",
        "Layout: Table rows or cells become editable in place with row-level save/cancel controls. Interaction: Users edit several fields quickly, validate, commit, or discard row changes. Variants: Single-cell editing, row editing, keyboard navigation, or draft autosave.",
        BlueprintSampleKind.CRUD,
        "Table rows or cells become editable in place with row-level save/cancel controls.", "Users edit several fields quickly, validate, commit, or discard row changes.");
  }
}
