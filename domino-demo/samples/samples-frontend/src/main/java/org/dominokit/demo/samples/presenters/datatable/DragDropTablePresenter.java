package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.dragdrop.DragDropTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DragDropTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DragDropTablePresenter extends ChildPresenter<ShellPresenter, DragDropTableView>
    implements DragDropTableView.DragDropTableUiHandlers {

  public static final String ROUTE = "datatable/drag-drop-plugin";
}
