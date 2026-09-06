package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.OfflineOrReconnectingWorkspaceView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(OfflineOrReconnectingWorkspacePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class OfflineOrReconnectingWorkspacePresenter extends ChildPresenter<ShellPresenter, OfflineOrReconnectingWorkspaceView>
    implements OfflineOrReconnectingWorkspaceView.OfflineOrReconnectingWorkspaceUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/offline-or-reconnecting-workspace";
}
