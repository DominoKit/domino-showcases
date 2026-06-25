package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.chips.ChipsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ChipsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ChipsPresenter extends ChildPresenter<ShellPresenter, ChipsView>
    implements ChipsView.ChipsUiHandlers {

  public static final String ROUTE = "components/chips";
}
