package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.FormsConfigurationAndDataEntryFlowsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/forms-configuration-and-data-entry-flows")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FormsConfigurationAndDataEntryFlowsPresenter extends ChildPresenter<ShellPresenter, FormsConfigurationAndDataEntryFlowsView>
    implements FormsConfigurationAndDataEntryFlowsView.FormsConfigurationAndDataEntryFlowsUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows";
}
