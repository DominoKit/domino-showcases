package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.columnresize.ColumnResizeView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ColumnResizePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ColumnResizePresenter extends ChildPresenter<ShellPresenter, ColumnResizeView>
    implements ColumnResizeView.ColumnResizeUiHandlers {

  public static final String ROUTE = "datatable/column-resize-plugin";
}
