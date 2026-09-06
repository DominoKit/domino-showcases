package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MultiRecordComparisonWorkspaceView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MultiRecordComparisonWorkspacePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MultiRecordComparisonWorkspacePresenter extends ChildPresenter<ShellPresenter, MultiRecordComparisonWorkspaceView>
    implements MultiRecordComparisonWorkspaceView.MultiRecordComparisonWorkspaceUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/multi-record-comparison-workspace";
}
