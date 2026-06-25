package org.dominokit.pages.presenters.samples.icons;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.ListenFor;
import org.dominokit.brix.annotations.OnStateChanged;
import org.dominokit.brix.annotations.QueryParameter;
import org.dominokit.brix.api.Presenter;
import org.dominokit.pages.shared.events.ContentState;
import org.dominokit.pages.views.IconsView;

import java.util.List;

@BrixPresenter
@BrixRoute( "solutions/domino-ui/v2/docs/mdi-icons")
@BrixSlot("dui-demo-sample-slot")
public class IconsProxy extends Presenter<IconsView> implements IconsView.IconsUiHandlers {

    @QueryParameter
    List<String> tag;

    @Override
    protected boolean isAutoReveal() {
        return false;
    }

    @ListenFor(ContentState.class)
    public void onContentReadyIcons(ContentState event) {
        reveal();
            view.setTag(tag.get(0));
    }

    @OnStateChanged
    public void onTagChanged() {
        view.setTag(tag.get(0));
    }

}
