package org.dominokit.pages.presenters.samples.data;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.ListenFor;
import org.dominokit.brix.api.Presenter;
import org.dominokit.pages.shared.events.ContentState;
import org.dominokit.pages.views.DataListView;

@BrixPresenter
@BrixRoute(DataListProxy.ROUTE)
@BrixSlot("dui-demo-sample-slot")
public class DataListProxy extends Presenter<DataListView> implements DataListView.DataListUiHandlers {

  public static final String ROUTE = "solutions/domino-ui/v2/docs/data/data-list";

  @ListenFor(ContentState.class)
  public void onContentReady(ContentState event) {
    reveal();
  }

  @Override
  protected boolean isAutoReveal() {
    return false;
  }
}
