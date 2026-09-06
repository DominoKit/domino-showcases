package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.ExportBuilderView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.ExportBuilderSample;

@UiView
public class ExportBuilderViewImpl extends SamplePageView<ExportBuilderView.ExportBuilderUiHandlers>
    implements ExportBuilderView {

  @Inject
  public ExportBuilderViewImpl() {
    super("Export builder", "Layout: Dataset selection, columns, filters, format, and delivery options are arranged as a short flow or form. Interaction: Users configure, preview, generate, download, or schedule an export. Variants: Immediate download, queued export, or recurring export.");
    addSample("Export builder", "Layout: Dataset selection, columns, filters, format, and delivery options are arranged as a short flow or form. Interaction: Users configure, preview, generate, download, or schedule an export. Variants: Immediate download, queued export, or recurring export.", ExportBuilderSample.class, ExportBuilderSample::create);
    initPage();
  }
}
