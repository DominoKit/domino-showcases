package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.sortsearch.TableSortAndSearchView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TableSortAndSearchPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TableSortAndSearchPresenter extends ChildPresenter<ShellPresenter, TableSortAndSearchView>
    implements TableSortAndSearchView.TableSortAndSearchUiHandlers {

  public static final String ROUTE = "datatable/sort-search-plugin";
}
