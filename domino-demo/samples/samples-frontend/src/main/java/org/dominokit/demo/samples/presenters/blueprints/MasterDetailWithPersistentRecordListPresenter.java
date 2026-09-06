package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MasterDetailWithPersistentRecordListView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MasterDetailWithPersistentRecordListPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MasterDetailWithPersistentRecordListPresenter extends ChildPresenter<ShellPresenter, MasterDetailWithPersistentRecordListView>
    implements MasterDetailWithPersistentRecordListView.MasterDetailWithPersistentRecordListUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/master-detail-with-persistent-record-list";
}
