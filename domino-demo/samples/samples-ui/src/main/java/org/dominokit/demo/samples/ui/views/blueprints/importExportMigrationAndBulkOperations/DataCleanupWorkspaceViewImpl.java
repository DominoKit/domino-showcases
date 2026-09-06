package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.DataCleanupWorkspaceView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.DataCleanupWorkspaceSample;

@UiView
public class DataCleanupWorkspaceViewImpl extends BlueprintSamplePageView<DataCleanupWorkspaceView.DataCleanupWorkspaceUiHandlers>
    implements DataCleanupWorkspaceView {

  @Inject
  public DataCleanupWorkspaceViewImpl() {
    super("Data cleanup workspace", "Layout: Duplicate/invalid candidates, matching rules, previewed merges, and action history are presented together. Interaction: Users review candidates, merge/suppress, apply rules, and undo where possible. Variants: Duplicate contacts, catalog cleanup, or master-data cleanup.");
    addSample("Data cleanup workspace", "Layout: Duplicate/invalid candidates, matching rules, previewed merges, and action history are presented together. Interaction: Users review candidates, merge/suppress, apply rules, and undo where possible. Variants: Duplicate contacts, catalog cleanup, or master-data cleanup.", DataCleanupWorkspaceSample.class, DataCleanupWorkspaceSample::create);
    initPage();
  }
}
