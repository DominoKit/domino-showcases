package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.applicationFoundationsAndNavigation.BreadcrumbAndBackStackWorkspaceView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(BreadcrumbAndBackStackWorkspacePresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class BreadcrumbAndBackStackWorkspacePresenter extends ChildPresenter<ShellPresenter, BreadcrumbAndBackStackWorkspaceView>
    implements BreadcrumbAndBackStackWorkspaceView.BreadcrumbAndBackStackWorkspaceUiHandlers {

  public static final String ROUTE = "blueprints/application-foundations-and-navigation/breadcrumb-and-back-stack-workspace";
}
