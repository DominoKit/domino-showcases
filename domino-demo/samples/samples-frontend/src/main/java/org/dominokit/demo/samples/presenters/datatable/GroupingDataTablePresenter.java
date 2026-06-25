package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.grouping.GroupingDataTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(GroupingDataTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class GroupingDataTablePresenter extends ChildPresenter<ShellPresenter, GroupingDataTableView>
    implements GroupingDataTableView.GroupingDataTableUiHandlers {

  public static final String ROUTE = "datatable/grouping-plugin";
}
