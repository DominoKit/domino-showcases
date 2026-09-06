package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.SplitViewNavigationShellView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SplitViewNavigationShellPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SplitViewNavigationShellPresenter extends ChildPresenter<ShellPresenter, SplitViewNavigationShellView>
    implements SplitViewNavigationShellView.SplitViewNavigationShellUiHandlers {

  public static final String ROUTE = "blueprints/page-layout-and-navigation/split-view-navigation-shell";
}
