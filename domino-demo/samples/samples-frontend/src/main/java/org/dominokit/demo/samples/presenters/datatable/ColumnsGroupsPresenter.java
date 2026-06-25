package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.columngroup.ColumnsGroupsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ColumnsGroupsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ColumnsGroupsPresenter extends ChildPresenter<ShellPresenter, ColumnsGroupsView>
    implements ColumnsGroupsView.ColumnsGroupsUiHandlers {

  public static final String ROUTE = "datatable/column-groups";
}
