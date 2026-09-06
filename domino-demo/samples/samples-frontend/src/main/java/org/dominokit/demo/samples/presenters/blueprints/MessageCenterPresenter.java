package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.MessageCenterView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MessageCenterPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MessageCenterPresenter extends ChildPresenter<ShellPresenter, MessageCenterView>
    implements MessageCenterView.MessageCenterUiHandlers {

  public static final String ROUTE = "blueprints/content-files-communication-and-collaboration/message-center";
}
