package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.masterdetail.MasterDetailBlueprintView;

public final class RecordPageWithSideInspectorSample {

  private RecordPageWithSideInspectorSample() {}

  public static MasterDetailBlueprintView create() {
    return MasterDetailBlueprintView.sideInspector();
  }
}
