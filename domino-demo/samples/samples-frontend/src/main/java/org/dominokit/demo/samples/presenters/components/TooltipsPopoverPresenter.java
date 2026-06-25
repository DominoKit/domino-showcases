package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.popover.TooltipsPopoverView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TooltipsPopoverPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TooltipsPopoverPresenter extends ChildPresenter<ShellPresenter, TooltipsPopoverView>
    implements TooltipsPopoverView.TooltipsPopoverUiHandlers {

  public static final String ROUTE = "components/tooltips-popover";
}
