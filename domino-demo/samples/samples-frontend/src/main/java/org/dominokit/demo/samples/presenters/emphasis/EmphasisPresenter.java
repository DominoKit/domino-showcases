package org.dominokit.demo.samples.presenters.emphasis;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.emphasis.EmphasisView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(EmphasisPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class EmphasisPresenter extends ChildPresenter<ShellPresenter, EmphasisView>
    implements EmphasisView.EmphasisUiHandlers {

  public static final String ROUTE = "themes/emphasis";
}
