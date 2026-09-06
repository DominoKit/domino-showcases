package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.ListWithRowExpansionView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ListWithRowExpansionPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ListWithRowExpansionPresenter extends ChildPresenter<ShellPresenter, ListWithRowExpansionView>
    implements ListWithRowExpansionView.ListWithRowExpansionUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/list-with-row-expansion";
}
