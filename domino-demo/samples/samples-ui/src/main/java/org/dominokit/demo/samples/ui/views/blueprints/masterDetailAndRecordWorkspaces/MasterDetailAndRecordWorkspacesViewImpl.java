package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.MasterDetailAndRecordWorkspacesView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.MasterDetailRecordPageSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.MasterDetailWithPersistentRecordListSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordOverviewWithRelatedEntitiesSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordPageWithActivityTimelineSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordPageWithSideInspectorSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.MultiRecordComparisonWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.RecordSplitViewWithPreviewAndEditModesSample;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.HierarchicalEntityExplorerSample;

@UiView
public class MasterDetailAndRecordWorkspacesViewImpl extends BrixView<HTMLDivElement, MasterDetailAndRecordWorkspacesView.MasterDetailAndRecordWorkspacesUiHandlers>
    implements MasterDetailAndRecordWorkspacesView {

  private final DivElement root;

  @Inject
  public MasterDetailAndRecordWorkspacesViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Master-detail and record workspaces",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Master-detail record page",
                    "Layout: Summary header and tabbed sections form the detail pane, usually reached from a list. Interaction: Users move between related sections, edit the record, and return to the originating list. Variants: Full page, split view, or nested route tabs.",
                    MasterDetailRecordPageSample.class,
                    MasterDetailRecordPageSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Master-detail with persistent record list",
                    "Layout: Searchable list remains on the left while the selected record fills the right pane. Interaction: Users move through records with next/previous controls or keyboard shortcuts. Variants: Email-like preview, ticket queue, or asset inspection.",
                    MasterDetailWithPersistentRecordListSample.class,
                    MasterDetailWithPersistentRecordListSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Record overview with related entities",
                    "Layout: Record header is followed by summary cards and related lists for contacts, transactions, files, or activities. Interaction: Users navigate among related entities, add related records, and return to the parent context. Variants: Tabs, stacked sections, or dashboard-like summary.",
                    RecordOverviewWithRelatedEntitiesSample.class,
                    RecordOverviewWithRelatedEntitiesSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Record page with activity timeline",
                    "Layout: Primary record details occupy one region and a chronological activity stream occupies another. Interaction: Users post notes, filter event types, expand events, and respond to tasks. Variants: Right rail, bottom timeline, or full-width activity tab.",
                    RecordPageWithActivityTimelineSample.class,
                    RecordPageWithActivityTimelineSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Record page with side inspector",
                    "Layout: Main content displays the record while a narrow inspector exposes metadata, ownership, permissions, or quick actions. Interaction: Users pin/unpin the inspector, change metadata, and execute contextual actions. Variants: Collapsible inspector, overlay inspector, or mobile bottom sheet.",
                    RecordPageWithSideInspectorSample.class,
                    RecordPageWithSideInspectorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Multi-record comparison workspace",
                    "Layout: Two or more records appear in aligned columns with a shared toolbar. Interaction: Users switch compared records, highlight differences, and copy or reconcile values. Variants: Two-way, three-way, or version comparison.",
                    MultiRecordComparisonWorkspaceSample.class,
                    MultiRecordComparisonWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Record split view with preview and edit modes",
                    "Layout: Selected record is shown in a preview state and can transition to an edit state in the same pane. Interaction: Users preview, edit, save, cancel, and move between records without leaving the list. Variants: Inline edit, side panel, or full-screen edit escalation.",
                    RecordSplitViewWithPreviewAndEditModesSample.class,
                    RecordSplitViewWithPreviewAndEditModesSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Hierarchical entity explorer",
                    "Layout: Tree or nested list shows parent-child entities beside a detail pane. Interaction: Users expand nodes, add children, move/reorder nodes, and inspect the selected entity. Variants: Organization chart, category tree, folder hierarchy, or dependency graph.",
                    HierarchicalEntityExplorerSample.class,
                    HierarchicalEntityExplorerSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
