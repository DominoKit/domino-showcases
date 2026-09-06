package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordPageWithSideInspectorView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordPageWithSideInspectorSample;

@UiView
public class RecordPageWithSideInspectorViewImpl extends SamplePageView<RecordPageWithSideInspectorView.RecordPageWithSideInspectorUiHandlers>
    implements RecordPageWithSideInspectorView {

  @Inject
  public RecordPageWithSideInspectorViewImpl() {
    super("Record page with side inspector", "Layout: Main content displays the record while a narrow inspector exposes metadata, ownership, permissions, or quick actions. Interaction: Users pin/unpin the inspector, change metadata, and execute contextual actions. Variants: Collapsible inspector, overlay inspector, or mobile bottom sheet.");
    addSample("Record page with side inspector", "Layout: Main content displays the record while a narrow inspector exposes metadata, ownership, permissions, or quick actions. Interaction: Users pin/unpin the inspector, change metadata, and execute contextual actions. Variants: Collapsible inspector, overlay inspector, or mobile bottom sheet.", RecordPageWithSideInspectorSample.class, RecordPageWithSideInspectorSample::create);
    initPage();
  }
}
