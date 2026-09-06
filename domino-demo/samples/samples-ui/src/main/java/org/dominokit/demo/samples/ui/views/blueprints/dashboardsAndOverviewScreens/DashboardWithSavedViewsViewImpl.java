package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.DashboardWithSavedViewsView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.DashboardWithSavedViewsSample;

@UiView
public class DashboardWithSavedViewsViewImpl extends BlueprintSamplePageView<DashboardWithSavedViewsView.DashboardWithSavedViewsUiHandlers>
    implements DashboardWithSavedViewsView {

  @Inject
  public DashboardWithSavedViewsViewImpl() {
    super("Dashboard with saved views", "Layout: Dashboard content is controlled by a saved-view selector beside filters and date controls. Interaction: Users apply, save, rename, share, or delete dashboard configurations. Variants: Personal-only views, team-shared views, or role-enforced defaults.");
    addSample("Dashboard with saved views", "Layout: Dashboard content is controlled by a saved-view selector beside filters and date controls. Interaction: Users apply, save, rename, share, or delete dashboard configurations. Variants: Personal-only views, team-shared views, or role-enforced defaults.", DashboardWithSavedViewsSample.class, DashboardWithSavedViewsSample::create);
    initPage();
  }
}
