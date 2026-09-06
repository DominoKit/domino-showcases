package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.MessageCenterView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.MessageCenterSample;

@UiView
public class MessageCenterViewImpl extends BlueprintSamplePageView<MessageCenterView.MessageCenterUiHandlers>
    implements MessageCenterView {

  @Inject
  public MessageCenterViewImpl() {
    super("Message center", "Layout: Conversation or notification list beside a message/detail pane and composer. Interaction: Users read, reply, forward, archive, search, and mark messages. Variants: Internal inbox, customer messages, or system notifications.");
    addSample("Message center", "Layout: Conversation or notification list beside a message/detail pane and composer. Interaction: Users read, reply, forward, archive, search, and mark messages. Variants: Internal inbox, customer messages, or system notifications.", MessageCenterSample.class, MessageCenterSample::create);
    initPage();
  }
}
