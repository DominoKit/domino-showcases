package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordPageWithSideInspectorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RecordPageWithSideInspectorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RecordPageWithSideInspectorPresenter extends ChildPresenter<ShellPresenter, RecordPageWithSideInspectorView>
    implements RecordPageWithSideInspectorView.RecordPageWithSideInspectorUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/record-page-with-side-inspector";
}
