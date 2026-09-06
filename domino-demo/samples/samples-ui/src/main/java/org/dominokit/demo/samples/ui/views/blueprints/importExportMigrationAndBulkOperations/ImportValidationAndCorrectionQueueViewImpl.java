package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.ImportValidationAndCorrectionQueueView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.ImportValidationAndCorrectionQueueSample;

@UiView
public class ImportValidationAndCorrectionQueueViewImpl extends BlueprintSamplePageView<ImportValidationAndCorrectionQueueView.ImportValidationAndCorrectionQueueUiHandlers>
    implements ImportValidationAndCorrectionQueueView {

  @Inject
  public ImportValidationAndCorrectionQueueViewImpl() {
    super("Import validation and correction queue", "Layout: Valid rows and invalid rows are summarized with an error table and correction editor. Interaction: Users fix values inline, download errors, revalidate, and continue or cancel. Variants: Row-level correction, cell-level correction, or rules-assisted correction.");
    addSample("Import validation and correction queue", "Layout: Valid rows and invalid rows are summarized with an error table and correction editor. Interaction: Users fix values inline, download errors, revalidate, and continue or cancel. Variants: Row-level correction, cell-level correction, or rules-assisted correction.", ImportValidationAndCorrectionQueueSample.class, ImportValidationAndCorrectionQueueSample::create);
    initPage();
  }
}
