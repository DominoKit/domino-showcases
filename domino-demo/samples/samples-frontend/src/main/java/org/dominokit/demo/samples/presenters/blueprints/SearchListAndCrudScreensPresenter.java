package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.SearchListAndCrudScreensView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/search-list-and-crud-screens")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SearchListAndCrudScreensPresenter extends ChildPresenter<ShellPresenter, SearchListAndCrudScreensView>
    implements SearchListAndCrudScreensView.SearchListAndCrudScreensUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens";
}
