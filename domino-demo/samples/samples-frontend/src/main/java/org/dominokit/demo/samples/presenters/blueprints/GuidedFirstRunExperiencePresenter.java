package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.GuidedFirstRunExperienceView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(GuidedFirstRunExperiencePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class GuidedFirstRunExperiencePresenter extends ChildPresenter<ShellPresenter, GuidedFirstRunExperienceView>
    implements GuidedFirstRunExperienceView.GuidedFirstRunExperienceUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/guided-first-run-experience";
}
