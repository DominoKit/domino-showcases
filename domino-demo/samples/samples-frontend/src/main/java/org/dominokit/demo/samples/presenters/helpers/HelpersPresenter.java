package org.dominokit.demo.samples.presenters.helpers;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.helpers.HelpersView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(HelpersPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class HelpersPresenter extends ChildPresenter<ShellPresenter, HelpersView>
    implements HelpersView.HelpersUiHandlers {

  public static final String ROUTE = "helpers";
}
