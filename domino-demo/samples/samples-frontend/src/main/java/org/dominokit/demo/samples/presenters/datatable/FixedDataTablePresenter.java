package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.fixed.FixedDataTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FixedDataTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FixedDataTablePresenter extends ChildPresenter<ShellPresenter, FixedDataTableView>
    implements FixedDataTableView.FixedDataTableUiHandlers {

  public static final String ROUTE = "datatable/fixed-table";
}
