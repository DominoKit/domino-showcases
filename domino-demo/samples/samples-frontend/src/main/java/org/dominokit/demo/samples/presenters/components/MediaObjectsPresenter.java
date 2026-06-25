package org.dominokit.demo.samples.presenters.components;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.components.media.MediaObjectsView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MediaObjectsPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MediaObjectsPresenter extends ChildPresenter<ShellPresenter, MediaObjectsView>
    implements MediaObjectsView.MediaObjectsUiHandlers {

  public static final String ROUTE = "components/media";
}
