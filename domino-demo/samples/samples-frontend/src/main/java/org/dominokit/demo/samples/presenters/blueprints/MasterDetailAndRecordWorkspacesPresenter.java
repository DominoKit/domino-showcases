package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MasterDetailAndRecordWorkspacesView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/master-detail-and-record-workspaces")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MasterDetailAndRecordWorkspacesPresenter extends ChildPresenter<ShellPresenter, MasterDetailAndRecordWorkspacesView>
    implements MasterDetailAndRecordWorkspacesView.MasterDetailAndRecordWorkspacesUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces";
}
