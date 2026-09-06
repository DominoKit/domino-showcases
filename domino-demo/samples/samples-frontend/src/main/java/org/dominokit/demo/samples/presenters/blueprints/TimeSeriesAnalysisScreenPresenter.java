package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.TimeSeriesAnalysisScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(TimeSeriesAnalysisScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class TimeSeriesAnalysisScreenPresenter extends ChildPresenter<ShellPresenter, TimeSeriesAnalysisScreenView>
    implements TimeSeriesAnalysisScreenView.TimeSeriesAnalysisScreenUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/time-series-analysis-screen";
}
