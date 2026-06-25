package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.tree.LazyTreeTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(LazyTreeTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class LazyTreeTablePresenter extends ChildPresenter<ShellPresenter, LazyTreeTableView>
    implements LazyTreeTableView.LazyTreeTableUiHandlers {

  public static final String ROUTE = "datatable/lazy-tree-plugin";
}
