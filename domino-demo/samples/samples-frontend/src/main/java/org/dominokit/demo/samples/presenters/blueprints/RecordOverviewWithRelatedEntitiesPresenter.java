package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordOverviewWithRelatedEntitiesView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RecordOverviewWithRelatedEntitiesPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RecordOverviewWithRelatedEntitiesPresenter extends ChildPresenter<ShellPresenter, RecordOverviewWithRelatedEntitiesView>
    implements RecordOverviewWithRelatedEntitiesView.RecordOverviewWithRelatedEntitiesUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/record-overview-with-related-entities";
}
