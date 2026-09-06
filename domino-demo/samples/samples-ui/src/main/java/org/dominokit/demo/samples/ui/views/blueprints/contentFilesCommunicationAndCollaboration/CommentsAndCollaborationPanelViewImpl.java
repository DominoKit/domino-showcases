package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.CommentsAndCollaborationPanelView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.CommentsAndCollaborationPanelSample;

@UiView
public class CommentsAndCollaborationPanelViewImpl extends SamplePageView<CommentsAndCollaborationPanelView.CommentsAndCollaborationPanelUiHandlers>
    implements CommentsAndCollaborationPanelView {

  @Inject
  public CommentsAndCollaborationPanelViewImpl() {
    super("Comments and collaboration panel", "Layout: Primary record/content is accompanied by threaded comments and mentions. Interaction: Users comment, mention, react, resolve, reopen, and filter threads. Variants: Right rail, inline anchored comments, or activity tab.");
    addSample("Comments and collaboration panel", "Layout: Primary record/content is accompanied by threaded comments and mentions. Interaction: Users comment, mention, react, resolve, reopen, and filter threads. Variants: Right rail, inline anchored comments, or activity tab.", CommentsAndCollaborationPanelSample.class, CommentsAndCollaborationPanelSample::create);
    initPage();
  }
}
