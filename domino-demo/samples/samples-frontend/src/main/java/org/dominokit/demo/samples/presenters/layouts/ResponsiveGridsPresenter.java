package org.dominokit.demo.samples.presenters.layouts;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.layouts.grids.ResponsiveGridsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ResponsiveGridsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ResponsiveGridsPresenter extends ChildPresenter<ShellPresenter, ResponsiveGridsView>
    implements ResponsiveGridsView.ResponsiveGridsUiHandlers {

  public static final String ROUTE = "layout/grids";
}
