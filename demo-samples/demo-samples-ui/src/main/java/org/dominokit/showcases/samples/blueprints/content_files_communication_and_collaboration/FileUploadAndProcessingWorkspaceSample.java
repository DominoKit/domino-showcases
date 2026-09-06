package org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class FileUploadAndProcessingWorkspaceSample {

  private FileUploadAndProcessingWorkspaceSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "File upload and processing workspace",
        "Layout: Drop zone, upload queue, validation results, and completed-file list. Interaction: Users add files, monitor progress, retry failures, remove items, and continue processing. Variants: Single upload, multi-file batch, or resumable upload.",
        BlueprintSampleKind.CONTENT,
        "Drop zone, upload queue, validation results, and completed-file list.", "Users add files, monitor progress, retry failures, remove items, and continue processing.");
  }
}
