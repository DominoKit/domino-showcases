package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ScheduledReportManagementView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ScheduledReportManagementPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ScheduledReportManagementPresenter extends ChildPresenter<ShellPresenter, ScheduledReportManagementView>
    implements ScheduledReportManagementView.ScheduledReportManagementUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/scheduled-report-management";
}
