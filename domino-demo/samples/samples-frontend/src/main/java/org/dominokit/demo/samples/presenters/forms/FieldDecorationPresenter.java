package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.annotations.RouteTrigger;
import org.dominokit.brix.annotations.Split;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.brix.api.Presenter;
import org.dominokit.demo.samples.views.forms.decoration.FieldDecorationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FieldDecorationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
@Split(module = "forms", trigger = @RouteTrigger("forms"))
public abstract class FieldDecorationPresenter extends Presenter<FieldDecorationView>
    implements FieldDecorationView.FieldDecorationUiHandlers {

  public static final String ROUTE = "forms/fields-decoration";
}
