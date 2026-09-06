package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.CapacityPlanningScreenView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.CapacityPlanningScreenSample;

@UiView
public class CapacityPlanningScreenViewImpl extends SamplePageView<CapacityPlanningScreenView.CapacityPlanningScreenUiHandlers>
    implements CapacityPlanningScreenView {

  @Inject
  public CapacityPlanningScreenViewImpl() {
    super("Capacity planning screen", "Layout: Demand, available capacity, allocation, and forecast are shown in aligned charts or tables. Interaction: Users change assumptions, allocate capacity, compare scenarios, and publish a plan. Variants: People, machines, budget, or support capacity.");
    addSample("Capacity planning screen", "Layout: Demand, available capacity, allocation, and forecast are shown in aligned charts or tables. Interaction: Users change assumptions, allocate capacity, compare scenarios, and publish a plan. Variants: People, machines, budget, or support capacity.", CapacityPlanningScreenSample.class, CapacityPlanningScreenSample::create);
    initPage();
  }
}
