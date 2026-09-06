package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class SearchFirstRecordDirectorySample {

  private SearchFirstRecordDirectorySample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Search-first record directory",
        "Layout: Prominent search input with optional advanced filters; results appear only after a query or suggested search. Interaction: Users search by text, identifier, or facets and open a result. Variants: Typeahead, command-style search, or federated results across entity types.",
        BlueprintSampleKind.CRUD,
        "Prominent search input with optional advanced filters; results appear only after a query or suggested search.", "Users search by text, identifier, or facets and open a result.");
  }
}
