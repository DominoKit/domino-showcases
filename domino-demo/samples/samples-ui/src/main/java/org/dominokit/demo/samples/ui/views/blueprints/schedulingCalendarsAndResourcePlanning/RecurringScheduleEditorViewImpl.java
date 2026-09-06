package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.RecurringScheduleEditorView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.RecurringScheduleEditorSample;

@UiView
public class RecurringScheduleEditorViewImpl extends BlueprintSamplePageView<RecurringScheduleEditorView.RecurringScheduleEditorUiHandlers>
    implements RecurringScheduleEditorView {

  @Inject
  public RecurringScheduleEditorViewImpl() {
    super("Recurring schedule editor", "Layout: Schedule details are paired with recurrence rules, exceptions, preview dates, and timezone controls. Interaction: Users define recurrence, add exceptions, preview occurrences, and save the schedule. Variants: Calendar recurrence, batch job schedule, or notification schedule.");
    addSample("Recurring schedule editor", "Layout: Schedule details are paired with recurrence rules, exceptions, preview dates, and timezone controls. Interaction: Users define recurrence, add exceptions, preview occurrences, and save the schedule. Variants: Calendar recurrence, batch job schedule, or notification schedule.", RecurringScheduleEditorSample.class, RecurringScheduleEditorSample::create);
    initPage();
  }
}
