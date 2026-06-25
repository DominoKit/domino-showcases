package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.tree.EagerTreeTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(EagerTreeTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class EagerTreeTablePresenter extends ChildPresenter<ShellPresenter, EagerTreeTableView>
    implements EagerTreeTableView.EagerTreeTableUiHandlers {

  public static final String ROUTE = "datatable/eager-tree-plugin";
}
