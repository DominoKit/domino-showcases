package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MasterDetailWithPersistentRecordListView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.MasterDetailWithPersistentRecordListSample;

@UiView
public class MasterDetailWithPersistentRecordListViewImpl extends SamplePageView<MasterDetailWithPersistentRecordListView.MasterDetailWithPersistentRecordListUiHandlers>
    implements MasterDetailWithPersistentRecordListView {

  @Inject
  public MasterDetailWithPersistentRecordListViewImpl() {
    super("Master-detail with persistent record list", "Layout: Searchable list remains on the left while the selected record fills the right pane. Interaction: Users move through records with next/previous controls or keyboard shortcuts. Variants: Email-like preview, ticket queue, or asset inspection.");
    addSample("Master-detail with persistent record list", "Layout: Searchable list remains on the left while the selected record fills the right pane. Interaction: Users move through records with next/previous controls or keyboard shortcuts. Variants: Email-like preview, ticket queue, or asset inspection.", MasterDetailWithPersistentRecordListSample.class, MasterDetailWithPersistentRecordListSample::create);
    initPage();
  }
}
