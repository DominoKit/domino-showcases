package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.RoleBasedHomeDashboardView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.RoleBasedHomeDashboardSample;

@UiView
public class RoleBasedHomeDashboardViewImpl extends SamplePageView<RoleBasedHomeDashboardView.RoleBasedHomeDashboardUiHandlers>
    implements RoleBasedHomeDashboardView {

  @Inject
  public RoleBasedHomeDashboardViewImpl() {
    super("Role-based home dashboard", "Layout: Personalized welcome area followed by role-specific shortcuts, assigned work, recent records, and metrics. Interaction: Users resume work, customize widgets, and dismiss or pin content. Variants: Employee, manager, administrator, or external-partner home.");
    addSample("Role-based home dashboard", "Layout: Personalized welcome area followed by role-specific shortcuts, assigned work, recent records, and metrics. Interaction: Users resume work, customize widgets, and dismiss or pin content. Variants: Employee, manager, administrator, or external-partner home.", RoleBasedHomeDashboardSample.class, RoleBasedHomeDashboardSample::create);
    initPage();
  }
}
