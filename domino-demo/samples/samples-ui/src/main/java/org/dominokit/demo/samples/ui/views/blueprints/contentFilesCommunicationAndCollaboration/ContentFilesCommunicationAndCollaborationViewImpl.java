package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.ContentFilesCommunicationAndCollaborationView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.DocumentLibrarySample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.FileUploadAndProcessingWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.RichContentEditorSample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.VersionedDocumentEditorSample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.MessageCenterSample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.AnnouncementAndBroadcastComposerSample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.CommentsAndCollaborationPanelSample;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.KnowledgeBaseBrowserSample;

@UiView
public class ContentFilesCommunicationAndCollaborationViewImpl extends BrixView<HTMLDivElement, ContentFilesCommunicationAndCollaborationView.ContentFilesCommunicationAndCollaborationUiHandlers>
    implements ContentFilesCommunicationAndCollaborationView {

  private final DivElement root;

  @Inject
  public ContentFilesCommunicationAndCollaborationViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Content, files, communication, and collaboration",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Document library",
                    "Layout: Folder/tree navigation, file list or cards, search/filter toolbar, and preview/detail panel. Interaction: Users upload, move, rename, download, share, archive, and preview files. Variants: Grid/list toggle, versioned documents, or permissions-aware library.",
                    DocumentLibrarySample.class,
                    DocumentLibrarySample::create))
            .appendChild(
                SampleShowcase.create(
                    "File upload and processing workspace",
                    "Layout: Drop zone, upload queue, validation results, and completed-file list. Interaction: Users add files, monitor progress, retry failures, remove items, and continue processing. Variants: Single upload, multi-file batch, or resumable upload.",
                    FileUploadAndProcessingWorkspaceSample.class,
                    FileUploadAndProcessingWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Rich content editor",
                    "Layout: Editor canvas with formatting toolbar, metadata panel, preview, and publish controls. Interaction: Users draft, format, insert media, preview, autosave, and publish or schedule content. Variants: Knowledge article, email template, announcement, or policy document.",
                    RichContentEditorSample.class,
                    RichContentEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Versioned document editor",
                    "Layout: Editor is paired with version history, status, reviewers, and change metadata. Interaction: Users save versions, compare revisions, restore, submit for review, and publish. Variants: Side-by-side diff, inline diff, or review comments.",
                    VersionedDocumentEditorSample.class,
                    VersionedDocumentEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Message center",
                    "Layout: Conversation or notification list beside a message/detail pane and composer. Interaction: Users read, reply, forward, archive, search, and mark messages. Variants: Internal inbox, customer messages, or system notifications.",
                    MessageCenterSample.class,
                    MessageCenterSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Announcement and broadcast composer",
                    "Layout: Audience selector, message editor, scheduling controls, preview, and delivery summary. Interaction: Users target audiences, preview channels, schedule, send, cancel, and inspect delivery. Variants: In-app, email, SMS, or multi-channel broadcast.",
                    AnnouncementAndBroadcastComposerSample.class,
                    AnnouncementAndBroadcastComposerSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Comments and collaboration panel",
                    "Layout: Primary record/content is accompanied by threaded comments and mentions. Interaction: Users comment, mention, react, resolve, reopen, and filter threads. Variants: Right rail, inline anchored comments, or activity tab.",
                    CommentsAndCollaborationPanelSample.class,
                    CommentsAndCollaborationPanelSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Knowledge base browser",
                    "Layout: Category navigation, search, article list, and reading pane. Interaction: Users search, browse categories, bookmark, rate, report outdated content, and follow related articles. Variants: Public help center, internal knowledge base, or contextual help drawer.",
                    KnowledgeBaseBrowserSample.class,
                    KnowledgeBaseBrowserSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
