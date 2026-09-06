package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.SpecialStatesAndConstrainedCompositionsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/special-states-and-constrained-compositions")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SpecialStatesAndConstrainedCompositionsPresenter extends ChildPresenter<ShellPresenter, SpecialStatesAndConstrainedCompositionsView>
    implements SpecialStatesAndConstrainedCompositionsView.SpecialStatesAndConstrainedCompositionsUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions";
}
