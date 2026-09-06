package org.dominokit.demo.samples.ui.views.blueprints.masterDetailAndRecordWorkspaces;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.masterDetailAndRecordWorkspaces.HierarchicalEntityExplorerView;
import org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces.HierarchicalEntityExplorerSample;

@UiView
public class HierarchicalEntityExplorerViewImpl extends BlueprintSamplePageView<HierarchicalEntityExplorerView.HierarchicalEntityExplorerUiHandlers>
    implements HierarchicalEntityExplorerView {

  @Inject
  public HierarchicalEntityExplorerViewImpl() {
    super("Hierarchical entity explorer", "Layout: Tree or nested list shows parent-child entities beside a detail pane. Interaction: Users expand nodes, add children, move/reorder nodes, and inspect the selected entity. Variants: Organization chart, category tree, folder hierarchy, or dependency graph.");
    addSample("Hierarchical entity explorer", "Layout: Tree or nested list shows parent-child entities beside a detail pane. Interaction: Users expand nodes, add children, move/reorder nodes, and inspect the selected entity. Variants: Organization chart, category tree, folder hierarchy, or dependency graph.", HierarchicalEntityExplorerSample.class, HierarchicalEntityExplorerSample::create);
    initPage();
  }
}
