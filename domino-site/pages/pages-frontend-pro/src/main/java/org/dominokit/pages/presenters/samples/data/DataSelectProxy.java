package org.dominokit.pages.presenters.samples.data;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.ListenFor;
import org.dominokit.brix.api.Presenter;
import org.dominokit.pages.shared.events.ContentState;
import org.dominokit.pages.views.DataSelectView;

@BrixPresenter
@BrixRoute(DataSelectProxy.ROUTE)
@BrixSlot("dui-demo-sample-slot")
public class DataSelectProxy extends Presenter<DataSelectView>
    implements DataSelectView.DataSelectUiHandlers {

  public static final String ROUTE = "solutions/domino-ui/v2/docs/data/data-select";

  @ListenFor(ContentState.class)
  public void onContentReady(ContentState event) {
    reveal();
  }

  @Override
  protected boolean isAutoReveal() {
    return false;
  }
}
