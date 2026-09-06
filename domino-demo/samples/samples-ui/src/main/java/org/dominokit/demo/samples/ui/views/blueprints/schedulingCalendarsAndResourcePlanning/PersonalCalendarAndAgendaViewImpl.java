package org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning;

import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.demo.samples.ui.views.SamplePageView;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.PersonalCalendarAndAgendaView;
import org.dominokit.showcases.samples.blueprints.scheduling_calendars_and_resource_planning.PersonalCalendarAndAgendaSample;

@UiView
public class PersonalCalendarAndAgendaViewImpl extends SamplePageView<PersonalCalendarAndAgendaView.PersonalCalendarAndAgendaUiHandlers>
    implements PersonalCalendarAndAgendaView {

  @Inject
  public PersonalCalendarAndAgendaViewImpl() {
    super("Personal calendar and agenda", "Layout: Calendar grid or agenda list with mini-calendar, filters, and event detail. Interaction: Users create, move, resize, edit, cancel, and respond to events. Variants: Day/week/month, agenda-first, or compact mobile calendar.");
    addSample("Personal calendar and agenda", "Layout: Calendar grid or agenda list with mini-calendar, filters, and event detail. Interaction: Users create, move, resize, edit, cancel, and respond to events. Variants: Day/week/month, agenda-first, or compact mobile calendar.", PersonalCalendarAndAgendaSample.class, PersonalCalendarAndAgendaSample::create);
    initPage();
  }
}
