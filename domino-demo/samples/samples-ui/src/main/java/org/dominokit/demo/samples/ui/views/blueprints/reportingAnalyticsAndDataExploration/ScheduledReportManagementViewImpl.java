package org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ScheduledReportManagementView;
import org.dominokit.showcases.samples.blueprints.reporting_analytics_and_data_exploration.ScheduledReportManagementSample;

@UiView
public class ScheduledReportManagementViewImpl extends BlueprintSamplePageView<ScheduledReportManagementView.ScheduledReportManagementUiHandlers>
    implements ScheduledReportManagementView {

  @Inject
  public ScheduledReportManagementViewImpl() {
    super("Scheduled report management", "Layout: Report list includes schedule, recipients, delivery status, and last-run information. Interaction: Users create, pause, edit, test, duplicate, and monitor scheduled deliveries. Variants: Email delivery, file drop, dashboard refresh, or webhook delivery.");
    addSample("Scheduled report management", "Layout: Report list includes schedule, recipients, delivery status, and last-run information. Interaction: Users create, pause, edit, test, duplicate, and monitor scheduled deliveries. Variants: Email delivery, file drop, dashboard refresh, or webhook delivery.", ScheduledReportManagementSample.class, ScheduledReportManagementSample::create);
    initPage();
  }
}
