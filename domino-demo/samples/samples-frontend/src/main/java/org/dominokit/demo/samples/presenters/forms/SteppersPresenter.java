package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.forms.steppers.SteppersView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SteppersPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SteppersPresenter extends ChildPresenter<ShellPresenter, SteppersView>
    implements SteppersView.SteppersUiHandlers {

  public static final String ROUTE = "forms/steppers";
}
