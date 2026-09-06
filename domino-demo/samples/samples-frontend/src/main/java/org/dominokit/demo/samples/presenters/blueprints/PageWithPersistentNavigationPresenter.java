package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.pageLayoutAndNavigation.PageWithPersistentNavigationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(PageWithPersistentNavigationPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class PageWithPersistentNavigationPresenter extends ChildPresenter<ShellPresenter, PageWithPersistentNavigationView>
    implements PageWithPersistentNavigationView.PageWithPersistentNavigationUiHandlers {

  public static final String ROUTE = "blueprints/page-layout-and-navigation/page-with-persistent-navigation";
}
