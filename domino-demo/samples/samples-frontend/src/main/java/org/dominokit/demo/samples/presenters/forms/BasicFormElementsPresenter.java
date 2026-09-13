package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.RouteTrigger;
import org.dominokit.brix.annotations.Split;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.brix.api.Presenter;
import org.dominokit.demo.samples.views.forms.basic.BasicFormElementsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(BasicFormElementsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
@Split(module = "forms", trigger = @RouteTrigger("forms"))
public abstract class BasicFormElementsPresenter extends Presenter<BasicFormElementsView>
    implements BasicFormElementsView.BasicFormElementsUiHandlers {

  public static final String ROUTE = "forms/basic-form-elements";
}
