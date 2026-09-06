package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.masterdetail.MasterDetailHierarchyPane;
import org.dominokit.showcases.samples.blueprints.masterdetail.MasterDetailBlueprintView;

public final class HierarchicalEntityExplorerSample {

  private HierarchicalEntityExplorerSample() {}

  public static MasterDetailHierarchyPane create() {
    return MasterDetailBlueprintView.hierarchyExplorer();
  }
}
