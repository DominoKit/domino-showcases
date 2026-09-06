package org.dominokit.showcases.samples.blueprints.master_detail_and_record_workspaces;

import org.dominokit.showcases.samples.blueprints.masterdetail.MasterDetailBlueprintView;

public final class RecordSplitViewWithPreviewAndEditModesSample {

  private RecordSplitViewWithPreviewAndEditModesSample() {}

  public static MasterDetailBlueprintView create() {
    return MasterDetailBlueprintView.previewAndEdit();
  }
}
