package org.dominokit.demo.samples.presenters.forms;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.forms.datepicker.DatePickerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DatePickerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DatePickerPresenter extends ChildPresenter<ShellPresenter, DatePickerView>
    implements DatePickerView.DatePickerUiHandlers {

  public static final String ROUTE = "forms/datepicker";
}
