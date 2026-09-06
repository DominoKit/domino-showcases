package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.searchListAndCrudScreens.SearchFirstRecordDirectoryView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SearchFirstRecordDirectoryPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SearchFirstRecordDirectoryPresenter extends ChildPresenter<ShellPresenter, SearchFirstRecordDirectoryView>
    implements SearchFirstRecordDirectoryView.SearchFirstRecordDirectoryUiHandlers {

  public static final String ROUTE = "blueprints/search-list-and-crud-screens/search-first-record-directory";
}
