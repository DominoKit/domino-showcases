package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.forms.input.InputMaskView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(InputMaskPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class InputMaskPresenter extends ChildPresenter<ShellPresenter, InputMaskView>
    implements InputMaskView.InputMaskUiHandlers {

  public static final String ROUTE = "components/input-mask";
}
