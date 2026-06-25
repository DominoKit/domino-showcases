package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.scroll.ScrollLoadingView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ScrollLoadingPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ScrollLoadingPresenter extends ChildPresenter<ShellPresenter, ScrollLoadingView>
    implements ScrollLoadingView.ScrollLoadingUiHandlers {

  public static final String ROUTE = "datatable/scroll-loading";
}
