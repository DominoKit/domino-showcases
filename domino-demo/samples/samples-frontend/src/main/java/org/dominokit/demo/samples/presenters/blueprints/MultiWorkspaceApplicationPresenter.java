package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.MultiWorkspaceApplicationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MultiWorkspaceApplicationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MultiWorkspaceApplicationPresenter extends ChildPresenter<ShellPresenter, MultiWorkspaceApplicationView>
    implements MultiWorkspaceApplicationView.MultiWorkspaceApplicationUiHandlers {

  public static final String ROUTE = "blueprints/application-foundations-and-navigation/multi-workspace-application";
}
