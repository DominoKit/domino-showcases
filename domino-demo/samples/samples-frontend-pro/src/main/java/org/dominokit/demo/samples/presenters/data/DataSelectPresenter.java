package org.dominokit.demo.samples.presenters.data;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.data.DataSelectView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DataSelectPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DataSelectPresenter extends ChildPresenter<ShellPresenter, DataSelectView>
    implements DataSelectView.DataSelectUiHandlers {

  public static final String ROUTE = "data/data-select";
}
