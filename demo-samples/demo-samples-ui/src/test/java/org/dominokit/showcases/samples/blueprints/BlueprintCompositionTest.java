package org.dominokit.showcases.samples.blueprints;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlueprintCompositionTest {

  @Test
  public void resolvesDistinctEnterpriseCompositionsFromSampleNames() {
    assertEquals(BlueprintComposition.ADMINISTRATION_MATRIX,
        BlueprintComposition.resolve("Role and permission matrix", BlueprintSampleKind.ADMINISTRATION));
    assertEquals(BlueprintComposition.CONTENT_LIBRARY,
        BlueprintComposition.resolve("Document library", BlueprintSampleKind.CONTENT));
    assertEquals(BlueprintComposition.SAVED_VIEW_DASHBOARD,
        BlueprintComposition.resolve("Dashboard with saved views", BlueprintSampleKind.DASHBOARD));
    assertEquals(BlueprintComposition.STEPPER_FORM,
        BlueprintComposition.resolve("Stepped wizard", BlueprintSampleKind.FORM));
    assertEquals(BlueprintComposition.BULK_QUEUE,
        BlueprintComposition.resolve("Import validation and correction queue", BlueprintSampleKind.BULK));
    assertEquals(BlueprintComposition.AUDIT_TABLE,
        BlueprintComposition.resolve("Audit log explorer", BlueprintSampleKind.ADMINISTRATION));
    assertEquals(BlueprintComposition.PIVOT_ANALYSIS,
        BlueprintComposition.resolve("Ad hoc pivot analysis", BlueprintSampleKind.REPORT));
    assertEquals(BlueprintComposition.RESOURCE_SCHEDULER,
        BlueprintComposition.resolve("Resource scheduler", BlueprintSampleKind.SCHEDULING));
    assertEquals(BlueprintComposition.CRUD_DIALOG_LIST,
        BlueprintComposition.resolve("Short list CRUD with dialog editor", BlueprintSampleKind.CRUD));
    assertEquals(BlueprintComposition.KANBAN,
        BlueprintComposition.resolve("Kanban workflow board", BlueprintSampleKind.WORKFLOW));
    assertEquals(BlueprintComposition.OFFLINE_STATE,
        BlueprintComposition.resolve("Offline or reconnecting workspace", BlueprintSampleKind.STATE));
    assertEquals(BlueprintComposition.REPORT_BUILDER,
        BlueprintComposition.resolve("Report builder", BlueprintSampleKind.REPORT));
    assertEquals(BlueprintComposition.REPORT_MAP,
        BlueprintComposition.resolve("Geographic map analytics screen", BlueprintSampleKind.REPORT));
    assertEquals(BlueprintComposition.OPERATIONS_HEALTH,
        BlueprintComposition.resolve("Integration monitor", BlueprintSampleKind.OPERATIONS));
    assertEquals(BlueprintComposition.DETAIL_PREVIEW_EDIT,
        BlueprintComposition.resolve("Record split view with preview and edit modes", BlueprintSampleKind.DETAIL));
    assertEquals(BlueprintComposition.DETAIL_TIMELINE,
        BlueprintComposition.resolve("Record page with activity timeline", BlueprintSampleKind.DETAIL));
    assertEquals(BlueprintComposition.WORKFLOW_TIMELINE,
        BlueprintComposition.resolve("Workflow timeline and milestone view", BlueprintSampleKind.WORKFLOW));
    assertEquals(BlueprintComposition.WORKFLOW_CHECKLIST,
        BlueprintComposition.resolve("Task detail with checklist", BlueprintSampleKind.WORKFLOW));
    assertEquals(BlueprintComposition.STATE_PRINT,
        BlueprintComposition.resolve("Print/export-oriented screen", BlueprintSampleKind.STATE));
  }
}
