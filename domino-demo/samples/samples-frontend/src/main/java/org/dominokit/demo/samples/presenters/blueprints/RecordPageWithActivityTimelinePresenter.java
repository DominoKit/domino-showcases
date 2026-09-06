package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordPageWithActivityTimelineView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RecordPageWithActivityTimelinePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RecordPageWithActivityTimelinePresenter extends ChildPresenter<ShellPresenter, RecordPageWithActivityTimelineView>
    implements RecordPageWithActivityTimelineView.RecordPageWithActivityTimelineUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/record-page-with-activity-timeline";
}
