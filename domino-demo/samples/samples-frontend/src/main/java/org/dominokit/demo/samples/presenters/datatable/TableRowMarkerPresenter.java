package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.marker.TableRowMarkerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TableRowMarkerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TableRowMarkerPresenter extends ChildPresenter<ShellPresenter, TableRowMarkerView>
    implements TableRowMarkerView.TableRowMarkerUiHandlers {

  public static final String ROUTE = "datatable/marker-plugin";
}
