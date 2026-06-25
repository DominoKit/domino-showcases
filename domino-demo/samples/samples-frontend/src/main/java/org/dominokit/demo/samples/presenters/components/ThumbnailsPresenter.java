package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.thumbnails.ThumbnailsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ThumbnailsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ThumbnailsPresenter extends ChildPresenter<ShellPresenter, ThumbnailsView>
    implements ThumbnailsView.ThumbnailsUiHandlers {

  public static final String ROUTE = "components/thumbnails";
}
