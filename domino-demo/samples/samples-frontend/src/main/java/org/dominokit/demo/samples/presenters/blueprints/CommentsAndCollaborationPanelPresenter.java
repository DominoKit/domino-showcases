package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.CommentsAndCollaborationPanelView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(CommentsAndCollaborationPanelPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class CommentsAndCollaborationPanelPresenter extends ChildPresenter<ShellPresenter, CommentsAndCollaborationPanelView>
    implements CommentsAndCollaborationPanelView.CommentsAndCollaborationPanelUiHandlers {

  public static final String ROUTE = "blueprints/content-files-communication-and-collaboration/comments-and-collaboration-panel";
}
