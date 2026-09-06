package org.dominokit.demo.samples.ui.views.blueprints.importExportMigrationAndBulkOperations;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.importExportMigrationAndBulkOperations.DataExchangeStatusCenterView;
import org.dominokit.showcases.samples.blueprints.import_export_migration_and_bulk_operations.DataExchangeStatusCenterSample;

@UiView
public class DataExchangeStatusCenterViewImpl extends SamplePageView<DataExchangeStatusCenterView.DataExchangeStatusCenterUiHandlers>
    implements DataExchangeStatusCenterView {

  @Inject
  public DataExchangeStatusCenterViewImpl() {
    super("Data exchange status center", "Layout: Inbound/outbound exchanges are listed with direction, schedule, status, volume, and last successful run. Interaction: Users inspect an exchange, retry, download artifacts, and configure notifications. Variants: Partner exchange, regulatory submission, or scheduled feed.");
    addSample("Data exchange status center", "Layout: Inbound/outbound exchanges are listed with direction, schedule, status, volume, and last successful run. Interaction: Users inspect an exchange, retry, download artifacts, and configure notifications. Variants: Partner exchange, regulatory submission, or scheduled feed.", DataExchangeStatusCenterSample.class, DataExchangeStatusCenterSample::create);
    initPage();
  }
}
