package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.ShellWithPersistentNavigationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ShellWithPersistentNavigationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ShellWithPersistentNavigationPresenter extends ChildPresenter<ShellPresenter, ShellWithPersistentNavigationView>
    implements ShellWithPersistentNavigationView.ShellWithPersistentNavigationUiHandlers {

  public static final String ROUTE = "blueprints/application-foundations-and-navigation/shell-with-persistent-navigation";
}
