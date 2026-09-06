package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ReportingAnalyticsAndDataExplorationView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute("blueprints/reporting-analytics-and-data-exploration")
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ReportingAnalyticsAndDataExplorationPresenter extends ChildPresenter<ShellPresenter, ReportingAnalyticsAndDataExplorationView>
    implements ReportingAnalyticsAndDataExplorationView.ReportingAnalyticsAndDataExplorationUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration";
}
