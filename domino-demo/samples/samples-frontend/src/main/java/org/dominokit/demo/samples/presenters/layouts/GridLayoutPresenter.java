package org.dominokit.demo.samples.presenters.layouts;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.layouts.gridlayout.GridLayoutView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(GridLayoutPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class GridLayoutPresenter extends ChildPresenter<ShellPresenter, GridLayoutView>
    implements GridLayoutView.GridLayoutUiHandlers {

  public static final String ROUTE = "layout/grid-layout";
}
