package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.TwoColumnFormWithContextualHelpView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TwoColumnFormWithContextualHelpPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TwoColumnFormWithContextualHelpPresenter extends ChildPresenter<ShellPresenter, TwoColumnFormWithContextualHelpView>
    implements TwoColumnFormWithContextualHelpView.TwoColumnFormWithContextualHelpUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/two-column-form-with-contextual-help";
}
