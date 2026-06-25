package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.header.TableHeaderBarView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TableHeaderBarPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TableHeaderBarPresenter extends ChildPresenter<ShellPresenter, TableHeaderBarView>
    implements TableHeaderBarView.TableHeaderBarUiHandlers {

  public static final String ROUTE = "datatable/header-bar-plugin";
}
