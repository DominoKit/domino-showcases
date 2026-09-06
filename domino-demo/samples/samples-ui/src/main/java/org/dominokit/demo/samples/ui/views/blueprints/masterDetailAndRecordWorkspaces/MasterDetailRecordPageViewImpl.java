package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MasterDetailRecordPageView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.MasterDetailRecordPageSample;

@UiView
public class MasterDetailRecordPageViewImpl extends BlueprintSamplePageView<MasterDetailRecordPageView.MasterDetailRecordPageUiHandlers>
    implements MasterDetailRecordPageView {

  @Inject
  public MasterDetailRecordPageViewImpl() {
    super("Master-detail record page", "Layout: Summary header and tabbed sections form the detail pane, usually reached from a list. Interaction: Users move between related sections, edit the record, and return to the originating list. Variants: Full page, split view, or nested route tabs.");
    addSample("Master-detail record page", "Layout: Summary header and tabbed sections form the detail pane, usually reached from a list. Interaction: Users move between related sections, edit the record, and return to the originating list. Variants: Full page, split view, or nested route tabs.", MasterDetailRecordPageSample.class, MasterDetailRecordPageSample::create);
    initPage();
  }
}
