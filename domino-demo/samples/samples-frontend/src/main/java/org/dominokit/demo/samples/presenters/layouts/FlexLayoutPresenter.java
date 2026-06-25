package org.dominokit.demo.samples.presenters.layouts;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.layouts.flex.FlexLayoutView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FlexLayoutPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FlexLayoutPresenter extends ChildPresenter<ShellPresenter, FlexLayoutView>
    implements FlexLayoutView.FlexLayoutUiHandlers {

  public static final String ROUTE = "layout/flex-layout";
}
