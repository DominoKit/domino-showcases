package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.summary.TableSummaryView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TableSummaryPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TableSummaryPresenter extends ChildPresenter<ShellPresenter, TableSummaryView>
    implements TableSummaryView.TableSummaryUiHandlers {

  public static final String ROUTE = "datatable/summary-plugin";
}
