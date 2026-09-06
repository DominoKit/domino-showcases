package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.AdvancedSearchBuilderView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AdvancedSearchBuilderPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AdvancedSearchBuilderPresenter extends ChildPresenter<ShellPresenter, AdvancedSearchBuilderView>
    implements AdvancedSearchBuilderView.AdvancedSearchBuilderUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/advanced-search-builder";
}
