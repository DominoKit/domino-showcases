package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.ImportWizardWithMappingView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.ImportWizardWithMappingSample;

@UiView
public class ImportWizardWithMappingViewImpl extends SamplePageView<ImportWizardWithMappingView.ImportWizardWithMappingUiHandlers>
    implements ImportWizardWithMappingView {

  @Inject
  public ImportWizardWithMappingViewImpl() {
    super("Import wizard with mapping", "Layout: Upload step, column-mapping step, validation preview, and commit summary. Interaction: Users upload data, map source fields, resolve invalid rows, and start the import. Variants: CSV, spreadsheet, JSON, or copied tabular data.");
    addSample("Import wizard with mapping", "Layout: Upload step, column-mapping step, validation preview, and commit summary. Interaction: Users upload data, map source fields, resolve invalid rows, and start the import. Variants: CSV, spreadsheet, JSON, or copied tabular data.", ImportWizardWithMappingSample.class, ImportWizardWithMappingSample::create);
    initPage();
  }
}
