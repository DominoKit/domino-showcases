package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.columnpin.ColumnPinView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ColumnPinPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ColumnPinPresenter extends ChildPresenter<ShellPresenter, ColumnPinView>
    implements ColumnPinView.ColumnPinUiHandlers {

  public static final String ROUTE = "datatable/column-pin-plugin";
}
