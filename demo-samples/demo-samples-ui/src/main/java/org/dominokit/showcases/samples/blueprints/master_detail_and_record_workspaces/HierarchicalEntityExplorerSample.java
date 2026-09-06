package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.BlueprintSampleCanvas;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleKind;
import org.dominokit.showcases.samples.blueprints.BlueprintSampleSupport;

public final class HierarchicalEntityExplorerSample {

  private HierarchicalEntityExplorerSample() {}

  public static BlueprintSampleCanvas create() {
    return BlueprintSampleSupport.create(
        "Hierarchical entity explorer",
        "Layout: Tree or nested list shows parent-child entities beside a detail pane. Interaction: Users expand nodes, add children, move/reorder nodes, and inspect the selected entity. Variants: Organization chart, category tree, folder hierarchy, or dependency graph.",
        BlueprintSampleKind.DETAIL,
        "Tree or nested list shows parent-child entities beside a detail pane.", "Users expand nodes, add children, move/reorder nodes, and inspect the selected entity.");
  }
}
