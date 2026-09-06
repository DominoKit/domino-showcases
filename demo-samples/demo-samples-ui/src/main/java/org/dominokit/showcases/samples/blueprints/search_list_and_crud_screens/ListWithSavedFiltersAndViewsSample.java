package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class ListWithSavedFiltersAndViewsSample {

  private ListWithSavedFiltersAndViewsSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "List with saved filters and views",
        "Layout: Filter controls and a view selector sit above a reusable table/list. Interaction: Users save filter/sort/column configurations, share them, and set defaults. Variants: Personal/team scopes, pinned favorites, or permission-aware views.",
        BlueprintSampleKind.CRUD,
        "Filter controls and a view selector sit above a reusable table/list.", "Users save filter/sort/column configurations, share them, and set defaults.");
  }
}
