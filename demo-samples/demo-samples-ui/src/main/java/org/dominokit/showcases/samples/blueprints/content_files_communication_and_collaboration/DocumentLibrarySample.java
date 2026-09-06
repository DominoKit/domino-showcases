package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class DocumentLibrarySample {

  private DocumentLibrarySample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Document library",
        "Layout: Folder/tree navigation, file list or cards, search/filter toolbar, and preview/detail panel. Interaction: Users upload, move, rename, download, share, archive, and preview files. Variants: Grid/list toggle, versioned documents, or permissions-aware library.",
        BlueprintSampleKind.CONTENT,
        "Folder/tree navigation, file list or cards, search/filter toolbar, and preview/detail panel.", "Users upload, move, rename, download, share, archive, and preview files.");
  }
}
