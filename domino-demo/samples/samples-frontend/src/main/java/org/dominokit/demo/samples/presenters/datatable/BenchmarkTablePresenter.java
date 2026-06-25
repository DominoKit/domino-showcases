package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.benchmark.BenchmarkTableView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(BenchmarkTablePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class BenchmarkTablePresenter
    extends ChildPresenter<ShellPresenter, BenchmarkTableView>
    implements BenchmarkTableView.BenchmarkTableUiHandlers {

  public static final String ROUTE = "datatable/benchmark-table";
}
