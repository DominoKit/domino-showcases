package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.ShellWithContextualSecondaryNavigationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ShellWithContextualSecondaryNavigationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ShellWithContextualSecondaryNavigationPresenter extends ChildPresenter<ShellPresenter, ShellWithContextualSecondaryNavigationView>
    implements ShellWithContextualSecondaryNavigationView.ShellWithContextualSecondaryNavigationUiHandlers {

  public static final String ROUTE = "blueprints/page-layout-and-navigation/shell-with-contextual-secondary-navigation";
}
