package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.PortfolioOverviewDashboardView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.PortfolioOverviewDashboardSample;

@UiView
public class PortfolioOverviewDashboardViewImpl extends SamplePageView<PortfolioOverviewDashboardView.PortfolioOverviewDashboardUiHandlers>
    implements PortfolioOverviewDashboardView {

  @Inject
  public PortfolioOverviewDashboardViewImpl() {
    super("Portfolio overview dashboard", "Layout: Summary metrics, portfolio health indicators, grouped cards, and a comparison table cover many projects, products, or accounts. Interaction: Users compare entities, filter by owner/status, and open a selected portfolio member. Variants: Grid, table-first, or quadrant visualization.");
    addSample("Portfolio overview dashboard", "Layout: Summary metrics, portfolio health indicators, grouped cards, and a comparison table cover many projects, products, or accounts. Interaction: Users compare entities, filter by owner/status, and open a selected portfolio member. Variants: Grid, table-first, or quadrant visualization.", PortfolioOverviewDashboardSample.class, PortfolioOverviewDashboardSample::create);
    initPage();
  }
}
