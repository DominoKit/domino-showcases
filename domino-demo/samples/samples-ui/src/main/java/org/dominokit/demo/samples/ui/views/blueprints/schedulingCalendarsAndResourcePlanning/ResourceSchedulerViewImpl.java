package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.ResourceSchedulerView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.ResourceSchedulerSample;

@UiView
public class ResourceSchedulerViewImpl extends BlueprintSamplePageView<ResourceSchedulerView.ResourceSchedulerUiHandlers>
    implements ResourceSchedulerView {

  @Inject
  public ResourceSchedulerViewImpl() {
    super("Resource scheduler", "Layout: Resources form rows/columns while time forms the opposing axis; bookings appear as blocks. Interaction: Users create, move, resize, split, and cancel bookings while seeing conflicts. Variants: Gantt-like, timeline, calendar grid, or list-plus-calendar.");
    addSample("Resource scheduler", "Layout: Resources form rows/columns while time forms the opposing axis; bookings appear as blocks. Interaction: Users create, move, resize, split, and cancel bookings while seeing conflicts. Variants: Gantt-like, timeline, calendar grid, or list-plus-calendar.", ResourceSchedulerSample.class, ResourceSchedulerSample::create);
    initPage();
  }
}
