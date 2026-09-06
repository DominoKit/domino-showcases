package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ErrorRecoveryScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ErrorRecoveryScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ErrorRecoveryScreenPresenter extends ChildPresenter<ShellPresenter, ErrorRecoveryScreenView>
    implements ErrorRecoveryScreenView.ErrorRecoveryScreenUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/error-recovery-screen";
}
