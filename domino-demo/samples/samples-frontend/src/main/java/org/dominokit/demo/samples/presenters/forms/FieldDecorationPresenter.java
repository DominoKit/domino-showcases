package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.forms.decoration.FieldDecorationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FieldDecorationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FieldDecorationPresenter extends ChildPresenter<ShellPresenter, FieldDecorationView>
    implements FieldDecorationView.FieldDecorationUiHandlers {

  public static final String ROUTE = "forms/fields-decoration";
}
