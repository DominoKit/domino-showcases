package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.FacetedCatalogBrowserView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FacetedCatalogBrowserPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FacetedCatalogBrowserPresenter extends ChildPresenter<ShellPresenter, FacetedCatalogBrowserView>
    implements FacetedCatalogBrowserView.FacetedCatalogBrowserUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/faceted-catalog-browser";
}
