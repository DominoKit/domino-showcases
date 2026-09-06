package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.ContentFilesCommunicationAndCollaborationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/content-files-communication-and-collaboration")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ContentFilesCommunicationAndCollaborationPresenter extends ChildPresenter<ShellPresenter, ContentFilesCommunicationAndCollaborationView>
    implements ContentFilesCommunicationAndCollaborationView.ContentFilesCommunicationAndCollaborationUiHandlers {

  public static final String ROUTE = "blueprints/content-files-communication-and-collaboration";
}
