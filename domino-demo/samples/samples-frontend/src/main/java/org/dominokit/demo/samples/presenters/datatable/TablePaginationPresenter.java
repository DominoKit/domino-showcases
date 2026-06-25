package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.pagination.TablePaginationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TablePaginationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TablePaginationPresenter extends ChildPresenter<ShellPresenter, TablePaginationView>
    implements TablePaginationView.TablePaginationUiHandlers {

  public static final String ROUTE = "datatable/pagination-plugin";
}
