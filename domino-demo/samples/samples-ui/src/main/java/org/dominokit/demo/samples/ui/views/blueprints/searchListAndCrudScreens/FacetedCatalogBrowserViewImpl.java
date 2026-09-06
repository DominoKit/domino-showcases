package org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.FacetedCatalogBrowserView;
import org.dominokit.showcases.samples.blueprints.search_list_and_crud_screens.FacetedCatalogBrowserSample;

@UiView
public class FacetedCatalogBrowserViewImpl extends BlueprintSamplePageView<FacetedCatalogBrowserView.FacetedCatalogBrowserUiHandlers>
    implements FacetedCatalogBrowserView {

  @Inject
  public FacetedCatalogBrowserViewImpl() {
    super("Faceted catalog browser", "Layout: Facet sidebar, result count/sort toolbar, and a list or card grid. Interaction: Users combine facets, remove chips, sort, paginate, and open an item. Variants: Facets on the top for mobile, hierarchical facets, or instant result updates.");
    addSample("Faceted catalog browser", "Layout: Facet sidebar, result count/sort toolbar, and a list or card grid. Interaction: Users combine facets, remove chips, sort, paginate, and open an item. Variants: Facets on the top for mobile, hierarchical facets, or instant result updates.", FacetedCatalogBrowserSample.class, FacetedCatalogBrowserSample::create);
    initPage();
  }
}
