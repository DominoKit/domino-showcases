package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.BlueprintSamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.TimelinePlannerWithDependenciesView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.TimelinePlannerWithDependenciesSample;

@UiView
public class TimelinePlannerWithDependenciesViewImpl extends BlueprintSamplePageView<TimelinePlannerWithDependenciesView.TimelinePlannerWithDependenciesUiHandlers>
    implements TimelinePlannerWithDependenciesView {

  @Inject
  public TimelinePlannerWithDependenciesViewImpl() {
    super("Timeline planner with dependencies", "Layout: Work items are represented on a time axis with dependency connectors and milestone markers. Interaction: Users adjust dates, create dependencies, assign owners, and identify critical-path changes. Variants: Project plan, release plan, or implementation plan.");
    addSample("Timeline planner with dependencies", "Layout: Work items are represented on a time axis with dependency connectors and milestone markers. Interaction: Users adjust dates, create dependencies, assign owners, and identify critical-path changes. Variants: Project plan, release plan, or implementation plan.", TimelinePlannerWithDependenciesSample.class, TimelinePlannerWithDependenciesSample::create);
    initPage();
  }
}
