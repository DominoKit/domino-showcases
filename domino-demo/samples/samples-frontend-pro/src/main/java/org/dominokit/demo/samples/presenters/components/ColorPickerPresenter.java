package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.colorpicker.ColorPickerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ColorPickerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ColorPickerPresenter extends ChildPresenter<ShellPresenter, ColorPickerView>
    implements ColorPickerView.ColorPickerUiHandlers {

  public static final String ROUTE = "components/color-picker";
}
