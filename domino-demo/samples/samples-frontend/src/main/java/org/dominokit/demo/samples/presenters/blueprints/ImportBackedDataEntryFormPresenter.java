package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.ImportBackedDataEntryFormView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ImportBackedDataEntryFormPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ImportBackedDataEntryFormPresenter extends ChildPresenter<ShellPresenter, ImportBackedDataEntryFormView>
    implements ImportBackedDataEntryFormView.ImportBackedDataEntryFormUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/import-backed-data-entry-form";
}
