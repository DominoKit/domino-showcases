package org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class FacetedCatalogBrowserSample {

  private FacetedCatalogBrowserSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Faceted catalog browser",
        "Layout: Facet sidebar, result count/sort toolbar, and a list or card grid. Interaction: Users combine facets, remove chips, sort, paginate, and open an item. Variants: Facets on the top for mobile, hierarchical facets, or instant result updates.",
        BlueprintSampleKind.CRUD,
        "Facet sidebar, result count/sort toolbar, and a list or card grid.", "Users combine facets, remove chips, sort, paginate, and open an item.");
  }
}
