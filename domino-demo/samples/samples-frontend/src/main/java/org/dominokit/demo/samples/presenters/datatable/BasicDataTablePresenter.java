package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.basic.BasicDataTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(BasicDataTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class BasicDataTablePresenter extends ChildPresenter<ShellPresenter, BasicDataTableView>
    implements BasicDataTableView.BasicDataTableUiHandlers {

  public static final String ROUTE = "datatable/basic-table";
}
