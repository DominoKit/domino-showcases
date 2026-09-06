package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.AnnouncementAndBroadcastComposerView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AnnouncementAndBroadcastComposerPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AnnouncementAndBroadcastComposerPresenter extends ChildPresenter<ShellPresenter, AnnouncementAndBroadcastComposerView>
    implements AnnouncementAndBroadcastComposerView.AnnouncementAndBroadcastComposerUiHandlers {

  public static final String ROUTE = "blueprints/content-files-communication-and-collaboration/announcement-and-broadcast-composer";
}
