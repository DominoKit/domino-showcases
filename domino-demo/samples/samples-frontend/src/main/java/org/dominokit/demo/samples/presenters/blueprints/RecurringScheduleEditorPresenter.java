package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.schedulingCalendarsAndResourcePlanning.RecurringScheduleEditorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(RecurringScheduleEditorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class RecurringScheduleEditorPresenter extends ChildPresenter<ShellPresenter, RecurringScheduleEditorView>
    implements RecurringScheduleEditorView.RecurringScheduleEditorUiHandlers {

  public static final String ROUTE = "blueprints/scheduling-calendars-and-resource-planning/recurring-schedule-editor";
}
