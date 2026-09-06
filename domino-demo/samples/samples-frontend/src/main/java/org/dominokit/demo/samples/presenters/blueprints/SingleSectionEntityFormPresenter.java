package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.formsConfigurationAndDataEntryFlows.SingleSectionEntityFormView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(SingleSectionEntityFormPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class SingleSectionEntityFormPresenter extends ChildPresenter<ShellPresenter, SingleSectionEntityFormView>
    implements SingleSectionEntityFormView.SingleSectionEntityFormUiHandlers {

  public static final String ROUTE = "blueprints/forms-configuration-and-data-entry-flows/single-section-entity-form";
}
