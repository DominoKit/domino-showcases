package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.forms.advanced.AdvancedFormElementsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AdvancedFormElementsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AdvancedFormElementsPresenter extends ChildPresenter<ShellPresenter, AdvancedFormElementsView>
    implements AdvancedFormElementsView.AdvancedFormElementsUiHandlers {

  public static final String ROUTE = "forms/advanced-form-elements";
}
