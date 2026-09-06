package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.AnnouncementAndBroadcastComposerView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.AnnouncementAndBroadcastComposerSample;

@UiView
public class AnnouncementAndBroadcastComposerViewImpl extends BlueprintSamplePageView<AnnouncementAndBroadcastComposerView.AnnouncementAndBroadcastComposerUiHandlers>
    implements AnnouncementAndBroadcastComposerView {

  @Inject
  public AnnouncementAndBroadcastComposerViewImpl() {
    super("Announcement and broadcast composer", "Layout: Audience selector, message editor, scheduling controls, preview, and delivery summary. Interaction: Users target audiences, preview channels, schedule, send, cancel, and inspect delivery. Variants: In-app, email, SMS, or multi-channel broadcast.");
    addSample("Announcement and broadcast composer", "Layout: Audience selector, message editor, scheduling controls, preview, and delivery summary. Interaction: Users target audiences, preview channels, schedule, send, cancel, and inspect delivery. Variants: In-app, email, SMS, or multi-channel broadcast.", AnnouncementAndBroadcastComposerSample.class, AnnouncementAndBroadcastComposerSample::create);
    initPage();
  }
}
