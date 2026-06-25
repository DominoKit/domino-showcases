package org.dominokit.demo.samples.presenters.data;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.data.DataListView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DataListPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DataListPresenter extends ChildPresenter<ShellPresenter, DataListView>
    implements DataListView.DataListUiHandlers {

  public static final String ROUTE = "data/data-list";
}
