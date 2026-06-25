package org.dominokit.pages.presenters.samples.colors;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.ListenFor;
import org.dominokit.brix.annotations.QueryParameter;
import org.dominokit.brix.api.Presenter;
import org.dominokit.pages.shared.events.ContentState;
import org.dominokit.pages.views.ColorsView;
import java.util.List;

@BrixPresenter
@BrixRoute("solutions/domino-ui/v2/docs/colors")
@BrixSlot("dui-demo-sample-slot")
public class ColorsProxy extends Presenter<ColorsView> implements ColorsView.ColorsUiHandlers {

    @ListenFor(ContentState.class)
    public void onContentReady(ContentState event) {
        reveal();
    }

    @Override
    protected boolean isAutoReveal() {
        return false;
    }

}
