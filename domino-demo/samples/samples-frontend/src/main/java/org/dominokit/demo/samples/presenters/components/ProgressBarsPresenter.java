package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.progress.ProgressBarsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ProgressBarsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ProgressBarsPresenter extends ChildPresenter<ShellPresenter, ProgressBarsView>
    implements ProgressBarsView.ProgressBarsUiHandlers {

  public static final String ROUTE = "components/progress";
}
