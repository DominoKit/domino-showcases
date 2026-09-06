package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.VersionedDocumentEditorView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.VersionedDocumentEditorSample;

@UiView
public class VersionedDocumentEditorViewImpl extends SamplePageView<VersionedDocumentEditorView.VersionedDocumentEditorUiHandlers>
    implements VersionedDocumentEditorView {

  @Inject
  public VersionedDocumentEditorViewImpl() {
    super("Versioned document editor", "Layout: Editor is paired with version history, status, reviewers, and change metadata. Interaction: Users save versions, compare revisions, restore, submit for review, and publish. Variants: Side-by-side diff, inline diff, or review comments.");
    addSample("Versioned document editor", "Layout: Editor is paired with version history, status, reviewers, and change metadata. Interaction: Users save versions, compare revisions, restore, submit for review, and publish. Variants: Side-by-side diff, inline diff, or review comments.", VersionedDocumentEditorSample.class, VersionedDocumentEditorSample::create);
    initPage();
  }
}
