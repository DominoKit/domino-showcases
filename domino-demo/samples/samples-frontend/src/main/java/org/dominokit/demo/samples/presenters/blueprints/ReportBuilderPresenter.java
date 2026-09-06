package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ReportBuilderView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ReportBuilderPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ReportBuilderPresenter extends ChildPresenter<ShellPresenter, ReportBuilderView>
    implements ReportBuilderView.ReportBuilderUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/report-builder";
}
