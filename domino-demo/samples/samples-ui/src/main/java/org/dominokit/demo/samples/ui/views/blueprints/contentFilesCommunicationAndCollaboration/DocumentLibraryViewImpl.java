package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.DocumentLibraryView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.DocumentLibrarySample;

@UiView
public class DocumentLibraryViewImpl extends SamplePageView<DocumentLibraryView.DocumentLibraryUiHandlers>
    implements DocumentLibraryView {

  @Inject
  public DocumentLibraryViewImpl() {
    super("Document library", "Layout: Folder/tree navigation, file list or cards, search/filter toolbar, and preview/detail panel. Interaction: Users upload, move, rename, download, share, archive, and preview files. Variants: Grid/list toggle, versioned documents, or permissions-aware library.");
    addSample("Document library", "Layout: Folder/tree navigation, file list or cards, search/filter toolbar, and preview/detail panel. Interaction: Users upload, move, rename, download, share, archive, and preview files. Variants: Grid/list toggle, versioned documents, or permissions-aware library.", DocumentLibrarySample.class, DocumentLibrarySample::create);
    initPage();
  }
}
