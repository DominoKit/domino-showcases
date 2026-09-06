package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.specialStatesAndConstrainedCompositions.ResponsiveDensityTransformationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ResponsiveDensityTransformationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ResponsiveDensityTransformationPresenter extends ChildPresenter<ShellPresenter, ResponsiveDensityTransformationView>
    implements ResponsiveDensityTransformationView.ResponsiveDensityTransformationUiHandlers {

  public static final String ROUTE = "blueprints/special-states-and-constrained-compositions/responsive-density-transformation";
}
