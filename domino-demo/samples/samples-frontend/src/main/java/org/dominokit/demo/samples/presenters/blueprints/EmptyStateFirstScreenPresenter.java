package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.EmptyStateFirstScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(EmptyStateFirstScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class EmptyStateFirstScreenPresenter extends ChildPresenter<ShellPresenter, EmptyStateFirstScreenView>
    implements EmptyStateFirstScreenView.EmptyStateFirstScreenUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/empty-state-first-screen";
}
