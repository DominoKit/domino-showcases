package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordSplitViewWithPreviewAndEditModesView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordSplitViewWithPreviewAndEditModesSample;

@UiView
public class RecordSplitViewWithPreviewAndEditModesViewImpl extends BlueprintSamplePageView<RecordSplitViewWithPreviewAndEditModesView.RecordSplitViewWithPreviewAndEditModesUiHandlers>
    implements RecordSplitViewWithPreviewAndEditModesView {

  @Inject
  public RecordSplitViewWithPreviewAndEditModesViewImpl() {
    super("Record split view with preview and edit modes", "Layout: Selected record is shown in a preview state and can transition to an edit state in the same pane. Interaction: Users preview, edit, save, cancel, and move between records without leaving the list. Variants: Inline edit, side panel, or full-screen edit escalation.");
    addSample("Record split view with preview and edit modes", "Layout: Selected record is shown in a preview state and can transition to an edit state in the same pane. Interaction: Users preview, edit, save, cancel, and move between records without leaving the list. Variants: Inline edit, side panel, or full-screen edit escalation.", RecordSplitViewWithPreviewAndEditModesSample.class, RecordSplitViewWithPreviewAndEditModesSample::create);
    initPage();
  }
}
