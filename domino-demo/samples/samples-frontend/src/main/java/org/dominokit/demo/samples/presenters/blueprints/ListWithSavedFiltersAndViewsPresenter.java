package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ListWithSavedFiltersAndViewsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ListWithSavedFiltersAndViewsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ListWithSavedFiltersAndViewsPresenter extends ChildPresenter<ShellPresenter, ListWithSavedFiltersAndViewsView>
    implements ListWithSavedFiltersAndViewsView.ListWithSavedFiltersAndViewsUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/list-with-saved-filters-and-views";
}
