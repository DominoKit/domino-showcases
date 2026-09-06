package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.ReportViewerWithParameterBarView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(ReportViewerWithParameterBarPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class ReportViewerWithParameterBarPresenter extends ChildPresenter<ShellPresenter, ReportViewerWithParameterBarView>
    implements ReportViewerWithParameterBarView.ReportViewerWithParameterBarUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/report-viewer-with-parameter-bar";
}
