package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.collapsible.CollapsibleView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(CollapsiblePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class CollapsiblePresenter extends ChildPresenter<ShellPresenter, CollapsibleView>
    implements CollapsibleView.CollapsibleUiHandlers {

  public static final String ROUTE = "components/collapse";
}
