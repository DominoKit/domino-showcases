package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.Split;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.brix.api.Presenter;
import org.dominokit.demo.samples.views.components.buttons.ButtonsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ButtonsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
@Split
public abstract class ButtonsPresenter extends Presenter<ButtonsView>
    implements ButtonsView.ButtonsUiHandlers {

  public static final String ROUTE = "components/buttons";
}
