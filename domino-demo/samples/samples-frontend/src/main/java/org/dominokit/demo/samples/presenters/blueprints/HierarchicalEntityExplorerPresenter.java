package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.HierarchicalEntityExplorerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(HierarchicalEntityExplorerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class HierarchicalEntityExplorerPresenter extends ChildPresenter<ShellPresenter, HierarchicalEntityExplorerView>
    implements HierarchicalEntityExplorerView.HierarchicalEntityExplorerUiHandlers {

  public static final String ROUTE = "blueprints/master-detail-and-record-workspaces/hierarchical-entity-explorer";
}
