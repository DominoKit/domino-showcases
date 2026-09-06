package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.FormWithConditionalFieldsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FormWithConditionalFieldsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FormWithConditionalFieldsPresenter extends ChildPresenter<ShellPresenter, FormWithConditionalFieldsView>
    implements FormWithConditionalFieldsView.FormWithConditionalFieldsUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/form-with-conditional-fields";
}
