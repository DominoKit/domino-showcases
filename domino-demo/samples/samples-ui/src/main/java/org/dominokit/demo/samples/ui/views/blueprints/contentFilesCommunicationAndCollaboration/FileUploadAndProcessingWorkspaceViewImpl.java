package org.dominokit.demo.samples.ui.views.blueprints.contentFilesCommunicationAndCollaboration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.contentFilesCommunicationAndCollaboration.FileUploadAndProcessingWorkspaceView;
import org.dominokit.showcases.samples.blueprints.content_files_communication_and_collaboration.FileUploadAndProcessingWorkspaceSample;

@UiView
public class FileUploadAndProcessingWorkspaceViewImpl extends BlueprintSamplePageView<FileUploadAndProcessingWorkspaceView.FileUploadAndProcessingWorkspaceUiHandlers>
    implements FileUploadAndProcessingWorkspaceView {

  @Inject
  public FileUploadAndProcessingWorkspaceViewImpl() {
    super("File upload and processing workspace", "Layout: Drop zone, upload queue, validation results, and completed-file list. Interaction: Users add files, monitor progress, retry failures, remove items, and continue processing. Variants: Single upload, multi-file batch, or resumable upload.");
    addSample("File upload and processing workspace", "Layout: Drop zone, upload queue, validation results, and completed-file list. Interaction: Users add files, monitor progress, retry failures, remove items, and continue processing. Variants: Single upload, multi-file batch, or resumable upload.", FileUploadAndProcessingWorkspaceSample.class, FileUploadAndProcessingWorkspaceSample::create);
    initPage();
  }
}
