package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.RecordOverviewWithRelatedEntitiesView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordOverviewWithRelatedEntitiesSample;

@UiView
public class RecordOverviewWithRelatedEntitiesViewImpl extends BlueprintSamplePageView<RecordOverviewWithRelatedEntitiesView.RecordOverviewWithRelatedEntitiesUiHandlers>
    implements RecordOverviewWithRelatedEntitiesView {

  @Inject
  public RecordOverviewWithRelatedEntitiesViewImpl() {
    super("Record overview with related entities", "Layout: Record header is followed by summary cards and related lists for contacts, transactions, files, or activities. Interaction: Users navigate among related entities, add related records, and return to the parent context. Variants: Tabs, stacked sections, or dashboard-like summary.");
    addSample("Record overview with related entities", "Layout: Record header is followed by summary cards and related lists for contacts, transactions, files, or activities. Interaction: Users navigate among related entities, add related records, and return to the parent context. Variants: Tabs, stacked sections, or dashboard-like summary.", RecordOverviewWithRelatedEntitiesSample.class, RecordOverviewWithRelatedEntitiesSample::create);
    initPage();
  }
}
