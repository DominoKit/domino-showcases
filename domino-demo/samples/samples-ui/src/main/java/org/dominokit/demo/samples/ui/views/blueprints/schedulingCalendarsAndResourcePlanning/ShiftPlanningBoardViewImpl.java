package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.ShiftPlanningBoardView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.ShiftPlanningBoardSample;

@UiView
public class ShiftPlanningBoardViewImpl extends SamplePageView<ShiftPlanningBoardView.ShiftPlanningBoardUiHandlers>
    implements ShiftPlanningBoardView {

  @Inject
  public ShiftPlanningBoardViewImpl() {
    super("Shift planning board", "Layout: Staff rows and time periods contain shift blocks, coverage indicators, and unfilled slots. Interaction: Planners assign, drag, swap, copy, publish, and resolve coverage warnings. Variants: Weekly roster, monthly roster, or location-based roster.");
    addSample("Shift planning board", "Layout: Staff rows and time periods contain shift blocks, coverage indicators, and unfilled slots. Interaction: Planners assign, drag, swap, copy, publish, and resolve coverage warnings. Variants: Weekly roster, monthly roster, or location-based roster.", ShiftPlanningBoardSample.class, ShiftPlanningBoardSample::create);
    initPage();
  }
}
