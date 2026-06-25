package org.dominokit.demo.samples.presenters.colors;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.colors.ColorsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ColorsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ColorsPresenter extends ChildPresenter<ShellPresenter, ColorsView>
    implements ColorsView.ColorsUiHandlers {

  public static final String ROUTE = "colors";
}
