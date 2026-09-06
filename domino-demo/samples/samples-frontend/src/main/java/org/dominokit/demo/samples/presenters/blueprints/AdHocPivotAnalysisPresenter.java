package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.AdHocPivotAnalysisView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(AdHocPivotAnalysisPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class AdHocPivotAnalysisPresenter extends ChildPresenter<ShellPresenter, AdHocPivotAnalysisView>
    implements AdHocPivotAnalysisView.AdHocPivotAnalysisUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/ad-hoc-pivot-analysis";
}
