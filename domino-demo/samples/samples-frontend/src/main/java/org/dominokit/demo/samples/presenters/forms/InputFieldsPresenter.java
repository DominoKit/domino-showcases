package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.forms.inputfields.InputFieldsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(InputFieldsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class InputFieldsPresenter extends ChildPresenter<ShellPresenter, InputFieldsView>
    implements InputFieldsView.InputFieldsUiHandlers {

  public static final String ROUTE = "forms/input-fields";
}
