package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.top.TableTopPanelView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TableTopPanelPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TableTopPanelPresenter extends ChildPresenter<ShellPresenter, TableTopPanelView>
    implements TableTopPanelView.TableTopPanelUiHandlers {

  public static final String ROUTE = "datatable/top-panel-plugin";
}
