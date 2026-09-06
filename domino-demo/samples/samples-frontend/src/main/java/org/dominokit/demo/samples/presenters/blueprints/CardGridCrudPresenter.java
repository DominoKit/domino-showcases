package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.CardGridCrudView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(CardGridCrudPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class CardGridCrudPresenter extends ChildPresenter<ShellPresenter, CardGridCrudView>
    implements CardGridCrudView.CardGridCrudUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/card-grid-crud";
}
