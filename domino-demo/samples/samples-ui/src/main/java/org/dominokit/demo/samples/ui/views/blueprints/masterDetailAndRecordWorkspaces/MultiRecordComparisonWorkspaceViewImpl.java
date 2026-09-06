package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MultiRecordComparisonWorkspaceView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.MultiRecordComparisonWorkspaceSample;

@UiView
public class MultiRecordComparisonWorkspaceViewImpl extends BlueprintSamplePageView<MultiRecordComparisonWorkspaceView.MultiRecordComparisonWorkspaceUiHandlers>
    implements MultiRecordComparisonWorkspaceView {

  @Inject
  public MultiRecordComparisonWorkspaceViewImpl() {
    super("Multi-record comparison workspace", "Layout: Two or more records appear in aligned columns with a shared toolbar. Interaction: Users switch compared records, highlight differences, and copy or reconcile values. Variants: Two-way, three-way, or version comparison.");
    addSample("Multi-record comparison workspace", "Layout: Two or more records appear in aligned columns with a shared toolbar. Interaction: Users switch compared records, highlight differences, and copy or reconcile values. Variants: Two-way, three-way, or version comparison.", MultiRecordComparisonWorkspaceSample.class, MultiRecordComparisonWorkspaceSample::create);
    initPage();
  }
}
