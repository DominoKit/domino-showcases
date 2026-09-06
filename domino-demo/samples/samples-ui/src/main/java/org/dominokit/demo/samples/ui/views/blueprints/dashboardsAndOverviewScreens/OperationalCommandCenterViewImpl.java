package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.OperationalCommandCenterView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.OperationalCommandCenterSample;

@UiView
public class OperationalCommandCenterViewImpl extends BlueprintSamplePageView<OperationalCommandCenterView.OperationalCommandCenterUiHandlers>
    implements OperationalCommandCenterView {

  @Inject
  public OperationalCommandCenterViewImpl() {
    super("Operational command center", "Layout: Dense summary strip, alerts, live status panels, trend charts, and an active-work queue. Interaction: Users monitor changing conditions, acknowledge alerts, filter by severity, and jump to remediation screens. Variants: Auto-refresh, wallboard mode, or manually refreshed snapshot.");
    addSample("Operational command center", "Layout: Dense summary strip, alerts, live status panels, trend charts, and an active-work queue. Interaction: Users monitor changing conditions, acknowledge alerts, filter by severity, and jump to remediation screens. Variants: Auto-refresh, wallboard mode, or manually refreshed snapshot.", OperationalCommandCenterSample.class, OperationalCommandCenterSample::create);
    initPage();
  }
}
