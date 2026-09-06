package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.DataQualityScorecardView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(DataQualityScorecardPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class DataQualityScorecardPresenter extends ChildPresenter<ShellPresenter, DataQualityScorecardView>
    implements DataQualityScorecardView.DataQualityScorecardUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/data-quality-scorecard";
}
