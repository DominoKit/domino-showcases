package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.WorkspaceWithResizableNavigationPaneView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(WorkspaceWithResizableNavigationPanePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class WorkspaceWithResizableNavigationPanePresenter extends ChildPresenter<ShellPresenter, WorkspaceWithResizableNavigationPaneView>
    implements WorkspaceWithResizableNavigationPaneView.WorkspaceWithResizableNavigationPaneUiHandlers {

  public static final String ROUTE = "blueprints/page-layout-and-navigation/workspace-with-resizable-navigation-pane";
}
