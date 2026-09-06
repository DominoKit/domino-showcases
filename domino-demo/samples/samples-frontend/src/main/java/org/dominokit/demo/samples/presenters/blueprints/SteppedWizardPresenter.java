package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.SteppedWizardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SteppedWizardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SteppedWizardPresenter extends ChildPresenter<ShellPresenter, SteppedWizardView>
    implements SteppedWizardView.SteppedWizardUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/stepped-wizard";
}
