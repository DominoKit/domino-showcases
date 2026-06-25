package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.preloaders.PreLoadersView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(PreLoadersPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class PreLoadersPresenter extends ChildPresenter<ShellPresenter, PreLoadersView>
    implements PreLoadersView.PreLoadersUiHandlers {

  public static final String ROUTE = "components/preloaders";
}
