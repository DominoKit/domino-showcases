package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.breadcrumbs.BreadcrumbsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(BreadcrumbsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class BreadcrumbsPresenter extends ChildPresenter<ShellPresenter, BreadcrumbsView>
    implements BreadcrumbsView.BreadcrumbsUiHandlers {

  public static final String ROUTE = "components/breadcrumbs";
}
