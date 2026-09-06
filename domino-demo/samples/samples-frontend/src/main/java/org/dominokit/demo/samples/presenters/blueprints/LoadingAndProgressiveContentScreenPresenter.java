package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.LoadingAndProgressiveContentScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(LoadingAndProgressiveContentScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class LoadingAndProgressiveContentScreenPresenter extends ChildPresenter<ShellPresenter, LoadingAndProgressiveContentScreenView>
    implements LoadingAndProgressiveContentScreenView.LoadingAndProgressiveContentScreenUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/loading-and-progressive-content-screen";
}
