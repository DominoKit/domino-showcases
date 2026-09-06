package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.SchedulingCalendarsAndResourcePlanningView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.PersonalCalendarAndAgendaSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.SharedTeamCalendarSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.ResourceSchedulerSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.AppointmentBookingFlowSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.ShiftPlanningBoardSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.CapacityPlanningScreenSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.RecurringScheduleEditorSample;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.TimelinePlannerWithDependenciesSample;

@UiView
public class SchedulingCalendarsAndResourcePlanningViewImpl extends BrixView<HTMLDivElement, SchedulingCalendarsAndResourcePlanningView.SchedulingCalendarsAndResourcePlanningUiHandlers>
    implements SchedulingCalendarsAndResourcePlanningView {

  private final DivElement root;

  @Inject
  public SchedulingCalendarsAndResourcePlanningViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Scheduling, calendars, and resource planning",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Personal calendar and agenda",
                    "Layout: Calendar grid or agenda list with mini-calendar, filters, and event detail. Interaction: Users create, move, resize, edit, cancel, and respond to events. Variants: Day/week/month, agenda-first, or compact mobile calendar.",
                    PersonalCalendarAndAgendaSample.class,
                    PersonalCalendarAndAgendaSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Shared team calendar",
                    "Layout: Multiple calendars or resource lanes are displayed with a shared toolbar. Interaction: Users toggle calendars, schedule events, resolve overlaps, and inspect availability. Variants: Team members, rooms, equipment, or service territories.",
                    SharedTeamCalendarSample.class,
                    SharedTeamCalendarSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Resource scheduler",
                    "Layout: Resources form rows/columns while time forms the opposing axis; bookings appear as blocks. Interaction: Users create, move, resize, split, and cancel bookings while seeing conflicts. Variants: Gantt-like, timeline, calendar grid, or list-plus-calendar.",
                    ResourceSchedulerSample.class,
                    ResourceSchedulerSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Appointment booking flow",
                    "Layout: Service/resource selection, availability picker, customer details, and confirmation summary form a guided flow. Interaction: Users choose a slot, enter details, confirm, reschedule, or cancel. Variants: Public booking, staff booking, or assisted booking.",
                    AppointmentBookingFlowSample.class,
                    AppointmentBookingFlowSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Shift planning board",
                    "Layout: Staff rows and time periods contain shift blocks, coverage indicators, and unfilled slots. Interaction: Planners assign, drag, swap, copy, publish, and resolve coverage warnings. Variants: Weekly roster, monthly roster, or location-based roster.",
                    ShiftPlanningBoardSample.class,
                    ShiftPlanningBoardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Capacity planning screen",
                    "Layout: Demand, available capacity, allocation, and forecast are shown in aligned charts or tables. Interaction: Users change assumptions, allocate capacity, compare scenarios, and publish a plan. Variants: People, machines, budget, or support capacity.",
                    CapacityPlanningScreenSample.class,
                    CapacityPlanningScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Recurring schedule editor",
                    "Layout: Schedule details are paired with recurrence rules, exceptions, preview dates, and timezone controls. Interaction: Users define recurrence, add exceptions, preview occurrences, and save the schedule. Variants: Calendar recurrence, batch job schedule, or notification schedule.",
                    RecurringScheduleEditorSample.class,
                    RecurringScheduleEditorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Timeline planner with dependencies",
                    "Layout: Work items are represented on a time axis with dependency connectors and milestone markers. Interaction: Users adjust dates, create dependencies, assign owners, and identify critical-path changes. Variants: Project plan, release plan, or implementation plan.",
                    TimelinePlannerWithDependenciesSample.class,
                    TimelinePlannerWithDependenciesSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
