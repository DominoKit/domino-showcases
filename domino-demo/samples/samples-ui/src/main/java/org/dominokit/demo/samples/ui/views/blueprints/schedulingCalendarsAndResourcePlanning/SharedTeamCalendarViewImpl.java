package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.SharedTeamCalendarView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.SharedTeamCalendarSample;

@UiView
public class SharedTeamCalendarViewImpl extends BlueprintSamplePageView<SharedTeamCalendarView.SharedTeamCalendarUiHandlers>
    implements SharedTeamCalendarView {

  @Inject
  public SharedTeamCalendarViewImpl() {
    super("Shared team calendar", "Layout: Multiple calendars or resource lanes are displayed with a shared toolbar. Interaction: Users toggle calendars, schedule events, resolve overlaps, and inspect availability. Variants: Team members, rooms, equipment, or service territories.");
    addSample("Shared team calendar", "Layout: Multiple calendars or resource lanes are displayed with a shared toolbar. Interaction: Users toggle calendars, schedule events, resolve overlaps, and inspect availability. Variants: Team members, rooms, equipment, or service territories.", SharedTeamCalendarSample.class, SharedTeamCalendarSample::create);
    initPage();
  }
}
