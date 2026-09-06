package org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.dashboardsAndOverviewScreens.PersonalProductivityDashboardView;
import org.dominokit.showcases.samples.blueprints.dashboards_and_overview_screens.PersonalProductivityDashboardSample;

@UiView
public class PersonalProductivityDashboardViewImpl extends BlueprintSamplePageView<PersonalProductivityDashboardView.PersonalProductivityDashboardUiHandlers>
    implements PersonalProductivityDashboardView {

  @Inject
  public PersonalProductivityDashboardViewImpl() {
    super("Personal productivity dashboard", "Layout: Today/next-up summary, tasks, calendar preview, notifications, and recently opened items. Interaction: Users complete, snooze, reschedule, or resume work directly from compact widgets. Variants: Focus mode, team mode, or calendar-first arrangement.");
    addSample("Personal productivity dashboard", "Layout: Today/next-up summary, tasks, calendar preview, notifications, and recently opened items. Interaction: Users complete, snooze, reschedule, or resume work directly from compact widgets. Variants: Focus mode, team mode, or calendar-first arrangement.", PersonalProductivityDashboardSample.class, PersonalProductivityDashboardSample::create);
    initPage();
  }
}
