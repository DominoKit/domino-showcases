package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.InlineEditableTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(InlineEditableTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class InlineEditableTablePresenter extends ChildPresenter<ShellPresenter, InlineEditableTableView>
    implements InlineEditableTableView.InlineEditableTableUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/inline-editable-table";
}
