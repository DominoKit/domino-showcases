package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordSplitViewWithPreviewAndEditModesView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RecordSplitViewWithPreviewAndEditModesPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RecordSplitViewWithPreviewAndEditModesPresenter extends ChildPresenter<ShellPresenter, RecordSplitViewWithPreviewAndEditModesView>
    implements RecordSplitViewWithPreviewAndEditModesView.RecordSplitViewWithPreviewAndEditModesUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/record-split-view-with-preview-and-edit-modes";
}
