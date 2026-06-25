package org.dominokit.demo.samples.presenters.layouts;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.layouts.split.SplitPanelView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SplitPanelPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SplitPanelPresenter extends ChildPresenter<ShellPresenter, SplitPanelView>
    implements SplitPanelView.SplitPanelUiHandlers {

  public static final String ROUTE = "layout/split-panel";
}
