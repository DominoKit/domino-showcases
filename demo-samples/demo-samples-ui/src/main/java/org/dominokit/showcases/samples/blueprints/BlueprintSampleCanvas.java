package org.dominokit.showcases.samples.blueprints;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;
import static org.dominokit.domino.ui.utils.Domino.h;
import static org.dominokit.domino.ui.utils.Domino.p;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class BlueprintSampleCanvas extends BaseDominoElement<HTMLDivElement, BlueprintSampleCanvas> {

  private final DivElement root;
  private final DivElement feedback;

  public static BlueprintSampleCanvas create(
      String title, String description, BlueprintSampleKind kind, String... regions) {
    return new BlueprintSampleCanvas(title, description, kind, regions);
  }

  private BlueprintSampleCanvas(
      String title, String description, BlueprintSampleKind kind, String[] regions) {
    feedback = div().textContent("Ready for interaction");
    root = div().addCss(dui_flex, dui_flex_col, dui_gap_4, dui_p_4)
        .appendChild(h(4).textContent(title))
        .appendChild(p().textContent(description))
        .appendChild(renderComposition(title, kind, regions))
        .appendChild(Card.create("Interaction notes", "This composition is intentionally interactive so its information hierarchy can be evaluated.")
            .appendChild(div().addCss(dui_flex, dui_gap_4)
                .appendChild(Button.create(actionLabel(kind)).addClickListener(evt -> feedback.textContent("Primary action completed")))
                .appendChild(Button.create("Refresh").addClickListener(evt -> feedback.textContent("Content refreshed")))
                .appendChild(feedback)));
    init(this);
  }

  private DivElement renderComposition(String title, BlueprintSampleKind kind, String[] regions) {
    switch (BlueprintComposition.resolve(title, kind)) {
      case ADMINISTRATION_MATRIX:
      case WORKFLOW_MATRIX:
        return matrixWorkspace(regions);
      case ADMINISTRATION_POLICY:
      case FORM_CONDITIONAL:
        return formWorkspace("Rule and policy editor", regions);
      case ADMINISTRATION_COMPARISON:
      case CRUD_COMPARE:
      case DETAIL_COMPARE:
      case PIVOT_ANALYSIS:
        return comparisonWorkspace(regions);
      case ADMINISTRATION_DIRECTORY:
      case CONTENT_LIBRARY:
      case CRUD_SEARCH:
      case DETAIL_HIERARCHY:
        return listDetailWorkspace("Browse and inspect", regions);
      case ADMINISTRATION_SETTINGS:
      case FORM_SECTIONED:
      case FORM_PREVIEW:
        return formWorkspace("Settings and configuration", regions);
      case ADMINISTRATION_EVENT:
      case AUDIT_TABLE:
      case OPERATIONS_LOG:
        return eventTable(regions);
      case CONTENT_COLLABORATION:
      case CONTENT_MESSAGE:
        return collaborationWorkspace(regions);
      case CONTENT_COMPOSER:
      case CONTENT_VERSIONED:
        return editorWorkspace(regions);
      case CONTENT_UPLOAD:
      case BULK_QUEUE:
      case BULK_MONITOR:
      case BULK_MIGRATION:
        return processingWorkspace(regions);
      case SAVED_VIEW_DASHBOARD:
      case DASHBOARD_DRILLDOWN:
      case DASHBOARD_KPI:
      case DASHBOARD_COMMENTARY:
      case DASHBOARD_OPERATIONAL:
        return dashboardWorkspace(regions);
      case STEPPER_FORM:
        return stepperWorkspace(regions);
      case FORM_REPEATABLE:
        return repeatableForm(regions);
      case REPORT_BUILDER:
      case REPORT_PARAMETERS:
      case REPORT_TIMESERIES:
      case REPORT_MAP:
      case REPORT_GOVERNANCE:
        return reportWorkspace(regions);
      case RESOURCE_SCHEDULER:
      case SCHEDULING_CALENDAR:
      case SCHEDULING_BOOKING:
      case SCHEDULING_AGENDA:
        return calendarWorkspace(regions);
      case SCHEDULING_TIMELINE:
      case OPERATIONS_CHECKLIST:
      case WORKFLOW_TIMELINE:
        return timelineWorkspace(regions);
      case CRUD_DIALOG_LIST:
      case CRUD_SIDE_PANEL:
      case CRUD_INLINE_TABLE:
      case CRUD_CARD_GRID:
      case CRUD_FACETED:
      case CRUD_EXPANDABLE:
        return crudWorkspace(regions);
      case DETAIL_TIMELINE:
      case DETAIL_INSPECTOR:
      case DETAIL_PREVIEW_EDIT:
      case DETAIL_RECORD:
        return detailWorkspace(regions);
      case STATE_EMPTY:
      case STATE_ERROR:
      case STATE_LOADING:
      case OFFLINE_STATE:
      case STATE_CONFLICT:
      case STATE_ONBOARDING:
      case STATE_READONLY:
      case STATE_UNSAVED:
      case STATE_PRINT:
        return stateWorkspace(regions);
      case KANBAN:
        return kanbanWorkspace(regions);
      case WORKFLOW_QUEUE:
      case WORKFLOW_APPROVAL:
      case WORKFLOW_CASE:
      case WORKFLOW_SLA:
      case WORKFLOW_CHECKLIST:
      default:
        return workflowWorkspace(regions);
    }
  }

  private DivElement dashboardWorkspace(String[] regions) {
    DivElement root = stack();
    root.appendChild(toolbar("Date range", "Filters", "Save view"));
    DivElement metrics = grid("repeat(auto-fit, minmax(150px, 1fr))");
    for (int i = 0; i < 4; i++) {
      metrics.appendChild(BlueprintSampleSupport.panel(
          i == 0 ? "Throughput" : i == 1 ? "At risk" : i == 2 ? "Completed" : "SLA",
          metric(i)));
    }
    root.appendChild(metrics);
    root.appendChild(grid("minmax(0, 2fr) minmax(220px, 1fr)")
        .appendChild(BlueprintSampleSupport.panel("Trend and drill-down", value(regions, 0)))
        .appendChild(BlueprintSampleSupport.panel("Commentary and alerts", value(regions, 1))));
    return root;
  }

  private DivElement matrixWorkspace(String[] regions) {
    DivElement matrix = grid("minmax(180px, 1.5fr) repeat(3, minmax(90px, 1fr))");
    matrix.appendChild(BlueprintSampleSupport.panel("Resource / role", "Inherited permissions and policy scope"));
    matrix.appendChild(BlueprintSampleSupport.panel("View", "Permission"));
    matrix.appendChild(BlueprintSampleSupport.panel("Edit", "Permission"));
    matrix.appendChild(BlueprintSampleSupport.panel("Approve", "Permission"));
    for (int i = 0; i < 4; i++) {
      matrix.appendChild(BlueprintSampleSupport.panel(value(regions, i), "Inherited from parent scope"));
      matrix.appendChild(toggle("Allow"));
      matrix.appendChild(toggle("Deny"));
      matrix.appendChild(toggle("Review"));
    }
    return matrix;
  }

  private DivElement comparisonWorkspace(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Compare", "Filter differences", "Promote selected"));
    DivElement comparison = grid("repeat(3, minmax(180px, 1fr))");
    comparison.appendChild(BlueprintSampleSupport.panel("Baseline", value(regions, 0)));
    comparison.appendChild(BlueprintSampleSupport.panel("Current", value(regions, 1)));
    comparison.appendChild(BlueprintSampleSupport.panel("Differences", "Changed fields are highlighted for review."));
    return root.appendChild(comparison);
  }

  private DivElement listDetailWorkspace(String heading, String[] regions) {
    DivElement detail = BlueprintSampleSupport.panel("Selected item", value(regions, 1));
    DivElement list = stack().appendChild(h(5).textContent(heading));
    for (int i = 0; i < 4; i++) {
      int index = i;
      list.appendChild(Button.create(BlueprintFixtures.records().get(i))
          .addClickListener(event -> {
            detail.clearElement().appendChild(h(5).textContent("Selected item"))
                .appendChild(p().textContent(value(regions, Math.min(index, regions.length - 1))));
            feedback.textContent("Selected " + BlueprintFixtures.records().get(index));
          }));
    }
    return grid("minmax(180px, 1fr) minmax(280px, 2fr)")
        .appendChild(list)
        .appendChild(detail);
  }

  private DivElement formWorkspace(String heading, String[] regions) {
    DivElement root = stack().appendChild(toolbar("Save draft", "Validate", "Preview"));
    DivElement form = grid("repeat(2, minmax(200px, 1fr))");
    form.appendChild(BlueprintSampleSupport.panel(heading, value(regions, 0)));
    form.appendChild(BlueprintSampleSupport.panel("Context and guidance", value(regions, 1)));
    form.appendChild(BlueprintSampleSupport.panel("Conditions", "Field dependencies and validation messages appear inline."));
    form.appendChild(BlueprintSampleSupport.panel("Change summary", "Unsaved fields and affected resources are summarized here."));
    return root.appendChild(form);
  }

  private DivElement eventTable(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Search events", "Filter", "Export evidence"));
    for (int i = 0; i < 5; i++) {
      root.appendChild(div().cssText("display: grid; grid-template-columns: 140px 1fr auto; gap: 10px; align-items: center; border-bottom: 1px solid var(--dui-border-color, #d9e1ea); padding: 8px 0;")
          .appendChild(p().textContent("Today, 0" + i + ":2" + i))
          .appendChild(p().textContent(i == 0 ? value(regions, 0) : sampleRow(i)))
          .appendChild(Button.create("Inspect").addClickListener(event -> feedback.textContent("Event details opened"))));
    }
    return root;
  }

  private DivElement collaborationWorkspace(String[] regions) {
    DivElement root = grid("minmax(220px, 1.2fr) minmax(260px, 2fr) minmax(180px, 1fr)");
    root.appendChild(BlueprintSampleSupport.panel("Threads and conversations", value(regions, 0)));
    root.appendChild(BlueprintSampleSupport.panel("Primary content", "Record, message, or document remains the main context."));
    root.appendChild(stack().appendChild(h(5).textContent("Participants"))
        .appendChild(Button.create("Mention owner").addClickListener(event -> feedback.textContent("Mention inserted")))
        .appendChild(Button.create("Resolve thread").addClickListener(event -> feedback.textContent("Thread resolved"))));
    return root;
  }

  private DivElement editorWorkspace(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Bold", "Insert", "Preview", "Publish"));
    return root.appendChild(grid("minmax(260px, 2fr) minmax(200px, 1fr)")
        .appendChild(BlueprintSampleSupport.panel("Editor canvas", value(regions, 0)))
        .appendChild(BlueprintSampleSupport.panel("Metadata and versions", value(regions, 1))));
  }

  private DivElement processingWorkspace(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Add files", "Retry failed", "Continue"));
    root.appendChild(BlueprintSampleSupport.panel("Processing queue", value(regions, 0)));
    for (int i = 0; i < 4; i++) {
      root.appendChild(BlueprintSampleSupport.panel("Item " + (i + 1), i == 1 ? "Needs correction before processing" : "Validated · ready for next step"));
    }
    return root;
  }

  private DivElement stepperWorkspace(String[] regions) {
    DivElement root = stack();
    DivElement steps = row();
    DivElement body = BlueprintSampleSupport.panel("Step 1", value(regions, 0));
    for (int i = 0; i < 3; i++) {
      int step = i + 1;
      steps.appendChild(Button.create("Step " + step).addClickListener(event -> {
        body.clearElement().appendChild(h(5).textContent("Step " + step))
            .appendChild(p().textContent(value(regions, Math.min(step - 1, regions.length - 1))));
        feedback.textContent("Moved to step " + step);
      }));
    }
    return root.appendChild(steps).appendChild(body).appendChild(toolbar("Back", "Save draft", "Continue"));
  }

  private DivElement repeatableForm(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Add row", "Reorder", "Save collection"));
    for (int i = 0; i < 3; i++) {
      root.appendChild(BlueprintSampleSupport.panel("Collection item " + (i + 1), value(regions, i)));
    }
    return root;
  }

  private DivElement reportWorkspace(String[] regions) {
    return stack().appendChild(toolbar("Choose dimensions", "Run analysis", "Export"))
        .appendChild(grid("minmax(180px, 1fr) minmax(300px, 2fr)")
            .appendChild(BlueprintSampleSupport.panel("Analysis controls", value(regions, 0)))
            .appendChild(BlueprintSampleSupport.panel("Result visualization", value(regions, 1))))
        .appendChild(BlueprintSampleSupport.panel("Data table", "Rows, totals, and drill-through links remain available below the visualization."));
  }

  private DivElement calendarWorkspace(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Today", "Week", "Create booking"));
    DivElement calendar = grid("repeat(7, minmax(90px, 1fr))");
    for (int i = 0; i < 7; i++) {
      calendar.appendChild(BlueprintSampleSupport.panel("Day " + (i + 1), i == 2 ? value(regions, 0) : "Open capacity"));
    }
    return root.appendChild(calendar).appendChild(BlueprintSampleSupport.panel("Selected slot", value(regions, 1)));
  }

  private DivElement timelineWorkspace(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Filter stages", "Add milestone", "Complete next"));
    for (int i = 0; i < 5; i++) {
      root.appendChild(div().cssText("border-left: 3px solid var(--dui-primary-color, #4c6fff); padding: 4px 12px 10px; margin-left: 8px;")
          .appendChild(h(5).textContent("Milestone " + (i + 1)))
          .appendChild(p().textContent(i == 0 ? value(regions, 0) : "Owner · due date · current status")));
    }
    return root;
  }

  private DivElement crudWorkspace(String[] regions) {
    DivElement root = stack().appendChild(toolbar("Search", "Add record", "Bulk actions"));
    DivElement list = grid("repeat(auto-fit, minmax(220px, 1fr))");
    for (int i = 0; i < 6; i++) {
      int index = i;
      list.appendChild(BlueprintSampleSupport.panel("Record " + (i + 1), sampleRow(i))
          .appendChild(Button.create("Edit").addClickListener(event -> feedback.textContent("Editing record " + (index + 1)))));
    }
    return root.appendChild(list);
  }

  private DivElement detailWorkspace(String[] regions) {
    return grid("minmax(220px, 1fr) minmax(280px, 2fr)")
        .appendChild(BlueprintSampleSupport.panel("Record navigation", value(regions, 0)))
        .appendChild(stack()
            .appendChild(BlueprintSampleSupport.panel("Record detail", value(regions, 1)))
            .appendChild(toolbar("Summary", "Activity", "Related")));
  }

  private DivElement stateWorkspace(String[] regions) {
    DivElement state = BlueprintSampleSupport.panel("Workspace state", value(regions, 0));
    return stack().appendChild(state)
        .appendChild(BlueprintSampleSupport.panel("What happens next", value(regions, 1)))
        .appendChild(toolbar("Try again", "Continue", "Learn more"));
  }

  private DivElement kanbanWorkspace(String[] regions) {
    DivElement board = grid("repeat(4, minmax(170px, 1fr))");
    for (String column : new String[] {"Backlog", "In progress", "Review", "Done"}) {
      DivElement lane = stack().appendChild(h(5).textContent(column));
      for (int i = 0; i < 2; i++) {
        lane.appendChild(BlueprintSampleSupport.panel("Work item", i == 0 ? value(regions, 0) : "Owner · priority"));
      }
      board.appendChild(lane);
    }
    return board;
  }

  private DivElement workflowWorkspace(String[] regions) {
    return grid("minmax(220px, 1fr) minmax(280px, 2fr)")
        .appendChild(BlueprintSampleSupport.panel("Queue and filters", value(regions, 0)))
        .appendChild(stack()
            .appendChild(BlueprintSampleSupport.panel("Task or request", value(regions, 1)))
            .appendChild(toolbar("Approve", "Request changes", "Assign")));
  }

  private DivElement toolbar(String... labels) {
    DivElement toolbar = row();
    for (String label : labels) {
      toolbar.appendChild(Button.create(label).addClickListener(event -> feedback.textContent(label + " action selected")));
    }
    return toolbar;
  }

  private Button toggle(String label) {
    return Button.create(label).addClickListener(event -> feedback.textContent(label + " permission selected"));
  }

  private DivElement stack() {
    return div().cssText("display: flex; flex-direction: column; gap: 10px; min-width: 0;");
  }

  private DivElement row() {
    return div().cssText("display: flex; gap: 8px; align-items: center; flex-wrap: wrap;");
  }

  private DivElement grid(String columns) {
    return div().cssText("display: grid; grid-template-columns: " + columns + "; gap: 12px; align-items: start;");
  }

  private String value(String[] values, int index) {
    return values.length == 0 ? "Primary content region" : values[Math.min(index, values.length - 1)];
  }

  private String metric(int index) {
    return BlueprintFixtures.metrics().get(index % BlueprintFixtures.metrics().size()) + " · live sample data";
  }

  private String sampleRow(int index) {
    return BlueprintFixtures.records().get(index % BlueprintFixtures.records().size()) + " · "
        + BlueprintFixtures.statuses().get(index % BlueprintFixtures.statuses().size());
  }

  private String actionLabel(BlueprintSampleKind kind) {
    switch (kind) {
      case FORM:
        return "Save changes";
      case WORKFLOW:
        return "Advance workflow";
      case REPORT:
        return "Run report";
      case SCHEDULING:
        return "Create booking";
      case BULK:
        return "Review operation";
      case STATE:
        return "Try recovery";
      default:
        return "Open primary action";
    }
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
