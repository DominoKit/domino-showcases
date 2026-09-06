package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.FullScreenFocusedTaskShellView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(FullScreenFocusedTaskShellPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class FullScreenFocusedTaskShellPresenter extends ChildPresenter<ShellPresenter, FullScreenFocusedTaskShellView>
    implements FullScreenFocusedTaskShellView.FullScreenFocusedTaskShellUiHandlers {

  public static final String ROUTE = "blueprints/application-foundations-and-navigation/full-screen-focused-task-shell";
}
