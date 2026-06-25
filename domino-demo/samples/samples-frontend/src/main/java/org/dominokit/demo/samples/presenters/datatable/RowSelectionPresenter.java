package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.selection.RowSelectionView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RowSelectionPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RowSelectionPresenter extends ChildPresenter<ShellPresenter, RowSelectionView>
    implements RowSelectionView.RowSelectionUiHandlers {

  public static final String ROUTE = "datatable/selection-plugin";
}
