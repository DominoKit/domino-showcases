package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.BulkEditReviewScreenView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.BulkEditReviewScreenSample;

@UiView
public class BulkEditReviewScreenViewImpl extends SamplePageView<BulkEditReviewScreenView.BulkEditReviewScreenUiHandlers>
    implements BulkEditReviewScreenView {

  @Inject
  public BulkEditReviewScreenViewImpl() {
    super("Bulk edit review screen", "Layout: Selected records, proposed field changes, validation warnings, and impact summary appear before commit. Interaction: Users edit a shared value, review per-record exceptions, confirm, and monitor completion. Variants: Synchronous update, background job, or approval-required bulk change.");
    addSample("Bulk edit review screen", "Layout: Selected records, proposed field changes, validation warnings, and impact summary appear before commit. Interaction: Users edit a shared value, review per-record exceptions, confirm, and monitor completion. Variants: Synchronous update, background job, or approval-required bulk change.", BulkEditReviewScreenSample.class, BulkEditReviewScreenSample::create);
    initPage();
  }
}
