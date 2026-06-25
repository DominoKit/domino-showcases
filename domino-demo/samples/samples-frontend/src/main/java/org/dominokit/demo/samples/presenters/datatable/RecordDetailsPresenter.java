package org.dominokit.demo.samples.presenters.datatable;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.datatable.details.RecordDetailsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RecordDetailsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RecordDetailsPresenter extends ChildPresenter<ShellPresenter, RecordDetailsView>
    implements RecordDetailsView.RecordDetailsUiHandlers {

  public static final String ROUTE = "datatable/record-details-plugin";
}
