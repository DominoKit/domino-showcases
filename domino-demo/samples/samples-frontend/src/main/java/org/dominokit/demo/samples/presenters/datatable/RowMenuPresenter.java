package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.menu.RowMenuView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RowMenuPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RowMenuPresenter extends ChildPresenter<ShellPresenter, RowMenuView>
    implements RowMenuView.RowMenuUiHandlers {

  public static final String ROUTE = "datatable/row-menu-plugin";
}
