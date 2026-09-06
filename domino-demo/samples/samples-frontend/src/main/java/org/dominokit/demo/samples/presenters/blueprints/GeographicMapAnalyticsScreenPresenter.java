package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.GeographicMapAnalyticsScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(GeographicMapAnalyticsScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class GeographicMapAnalyticsScreenPresenter extends ChildPresenter<ShellPresenter, GeographicMapAnalyticsScreenView>
    implements GeographicMapAnalyticsScreenView.GeographicMapAnalyticsScreenUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/geographic-map-analytics-screen";
}
