package org.dominokit.demo.samples.presenters.layouts;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.layouts.applayout.AppLayoutView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AppLayoutPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AppLayoutPresenter extends ChildPresenter<ShellPresenter, AppLayoutView>
    implements AppLayoutView.AppLayoutUiHandlers {

  public static final String ROUTE = "layout/app-layout";
}
