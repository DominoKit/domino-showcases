package org.dominokit.showcases.samples.blueprints;

import java.util.Locale;

enum BlueprintComposition {
  ADMINISTRATION_MATRIX,
  ADMINISTRATION_POLICY,
  ADMINISTRATION_COMPARISON,
  ADMINISTRATION_DIRECTORY,
  ADMINISTRATION_SETTINGS,
  ADMINISTRATION_EVENT,
  AUDIT_TABLE,
  CONTENT_LIBRARY,
  CONTENT_COLLABORATION,
  CONTENT_COMPOSER,
  CONTENT_UPLOAD,
  CONTENT_MESSAGE,
  CONTENT_VERSIONED,
  SAVED_VIEW_DASHBOARD,
  DASHBOARD_DRILLDOWN,
  DASHBOARD_KPI,
  DASHBOARD_COMMENTARY,
  DASHBOARD_OPERATIONAL,
  STEPPER_FORM,
  FORM_SECTIONED,
  FORM_REPEATABLE,
  FORM_CONDITIONAL,
  FORM_PREVIEW,
  BULK_QUEUE,
  BULK_BUILDER,
  BULK_MONITOR,
  BULK_MIGRATION,
  OPERATIONS_TRIAGE,
  OPERATIONS_LOG,
  OPERATIONS_HEALTH,
  OPERATIONS_RECONCILIATION,
  OPERATIONS_CHECKLIST,
  PIVOT_ANALYSIS,
  REPORT_BUILDER,
  REPORT_PARAMETERS,
  REPORT_TIMESERIES,
  REPORT_MAP,
  REPORT_GOVERNANCE,
  SCHEDULING_CALENDAR,
  RESOURCE_SCHEDULER,
  SCHEDULING_TIMELINE,
  SCHEDULING_BOOKING,
  SCHEDULING_AGENDA,
  CRUD_DIALOG_LIST,
  CRUD_SIDE_PANEL,
  CRUD_INLINE_TABLE,
  CRUD_CARD_GRID,
  CRUD_FACETED,
  CRUD_COMPARE,
  CRUD_EXPANDABLE,
  CRUD_SEARCH,
  DETAIL_HIERARCHY,
  DETAIL_TIMELINE,
  DETAIL_INSPECTOR,
  DETAIL_COMPARE,
  DETAIL_PREVIEW_EDIT,
  DETAIL_RECORD,
  STATE_EMPTY,
  STATE_ERROR,
  STATE_LOADING,
  OFFLINE_STATE,
  STATE_CONFLICT,
  STATE_ONBOARDING,
  STATE_READONLY,
  STATE_UNSAVED,
  STATE_PRINT,
  KANBAN,
  WORKFLOW_QUEUE,
  WORKFLOW_CHECKLIST,
  WORKFLOW_TIMELINE,
  WORKFLOW_APPROVAL,
  WORKFLOW_MATRIX,
  WORKFLOW_CASE,
  WORKFLOW_SLA;

  static BlueprintComposition resolve(String title, BlueprintSampleKind kind) {
    String normalized = title == null ? "" : title.toLowerCase(Locale.ROOT);
    if (kind == BlueprintSampleKind.CRUD) {
      if (normalized.contains("dialog editor")) {
        return CRUD_DIALOG_LIST;
      }
      if (normalized.contains("side panel editor") || normalized.contains("persistent")) {
        return CRUD_SIDE_PANEL;
      }
      if (normalized.contains("inline") || normalized.contains("editable table")) {
        return CRUD_INLINE_TABLE;
      }
      if (normalized.contains("card grid")) {
        return CRUD_CARD_GRID;
      }
      if (normalized.contains("faceted") || normalized.contains("catalog")) {
        return CRUD_FACETED;
      }
      if (normalized.contains("comparison") || normalized.contains("compare")) {
        return CRUD_COMPARE;
      }
      if (normalized.contains("row expansion") || normalized.contains("expand")) {
        return CRUD_EXPANDABLE;
      }
      if (normalized.contains("search") || normalized.contains("directory") || normalized.contains("registry")) {
        return CRUD_SEARCH;
      }
    }
    if (kind == BlueprintSampleKind.FORM) {
      if (normalized.contains("wizard") || normalized.contains("stepped")) {
        return STEPPER_FORM;
      }
      if (normalized.contains("repeatable") || normalized.contains("collection")) {
        return FORM_REPEATABLE;
      }
      if (normalized.contains("conditional")) {
        return FORM_CONDITIONAL;
      }
      if (normalized.contains("preview") || normalized.contains("configuration")) {
        return FORM_PREVIEW;
      }
      return FORM_SECTIONED;
    }
    if (kind == BlueprintSampleKind.REPORT) {
      if (normalized.contains("pivot") || normalized.contains("ad hoc")) {
        return PIVOT_ANALYSIS;
      }
      if (normalized.contains("report builder")) {
        return REPORT_BUILDER;
      }
      if (normalized.contains("parameter")) {
        return REPORT_PARAMETERS;
      }
      if (normalized.contains("time series")) {
        return REPORT_TIMESERIES;
      }
      if (normalized.contains("map") || normalized.contains("geographic")) {
        return REPORT_MAP;
      }
      if (normalized.contains("scheduled")) {
        return REPORT_PARAMETERS;
      }
      return REPORT_GOVERNANCE;
    }
    if (kind == BlueprintSampleKind.OPERATIONS) {
      if (normalized.contains("triage") || normalized.contains("incident")) {
        return OPERATIONS_TRIAGE;
      }
      if (normalized.contains("log")) {
        return OPERATIONS_LOG;
      }
      if (normalized.contains("health") || normalized.contains("monitor")) {
        return OPERATIONS_HEALTH;
      }
      if (normalized.contains("reconciliation") || normalized.contains("transaction")) {
        return OPERATIONS_RECONCILIATION;
      }
      if (normalized.contains("checklist") || normalized.contains("inspection")) {
        return OPERATIONS_CHECKLIST;
      }
      return OPERATIONS_HEALTH;
    }
    if (kind == BlueprintSampleKind.DETAIL) {
      if (normalized.contains("hierarchical") || normalized.contains("hierarchy")) {
        return DETAIL_HIERARCHY;
      }
      if (normalized.contains("activity timeline")) {
        return DETAIL_TIMELINE;
      }
      if (normalized.contains("inspector")) {
        return DETAIL_INSPECTOR;
      }
      if (normalized.contains("comparison") || normalized.contains("compare")) {
        return DETAIL_COMPARE;
      }
      if (normalized.contains("preview") || normalized.contains("edit modes")) {
        return DETAIL_PREVIEW_EDIT;
      }
      return DETAIL_RECORD;
    }
    if (kind == BlueprintSampleKind.STATE) {
      if (normalized.contains("empty")) {
        return STATE_EMPTY;
      }
      if (normalized.contains("error") || normalized.contains("recovery")) {
        return STATE_ERROR;
      }
      if (normalized.contains("loading") || normalized.contains("progressive")) {
        return STATE_LOADING;
      }
      if (normalized.contains("offline") || normalized.contains("reconnecting")) {
        return OFFLINE_STATE;
      }
      if (normalized.contains("conflict")) {
        return STATE_CONFLICT;
      }
      if (normalized.contains("first-run") || normalized.contains("guided")) {
        return STATE_ONBOARDING;
      }
      if (normalized.contains("read-only") || normalized.contains("permission")) {
        return STATE_READONLY;
      }
      if (normalized.contains("unsaved")) {
        return STATE_UNSAVED;
      }
      if (normalized.contains("print") || normalized.contains("export-oriented")) {
        return STATE_PRINT;
      }
      return STATE_LOADING;
    }
    if (kind == BlueprintSampleKind.WORKFLOW) {
      if (normalized.contains("kanban")) {
        return KANBAN;
      }
      if (normalized.contains("queue") || normalized.contains("inbox")) {
        return WORKFLOW_QUEUE;
      }
      if (normalized.contains("checklist")) {
        return WORKFLOW_CHECKLIST;
      }
      if (normalized.contains("timeline") || normalized.contains("milestone")) {
        return WORKFLOW_TIMELINE;
      }
      if (normalized.contains("approval") || normalized.contains("request")) {
        return WORKFLOW_APPROVAL;
      }
      if (normalized.contains("matrix")) {
        return WORKFLOW_MATRIX;
      }
      if (normalized.contains("case")) {
        return WORKFLOW_CASE;
      }
      if (normalized.contains("sla") || normalized.contains("escalation")) {
        return WORKFLOW_SLA;
      }
      return WORKFLOW_QUEUE;
    }
    if (kind == BlueprintSampleKind.SCHEDULING) {
      if (normalized.contains("calendar") || normalized.contains("agenda")) {
        return SCHEDULING_CALENDAR;
      }
      if (normalized.contains("resource") || normalized.contains("capacity") || normalized.contains("shift")) {
        return RESOURCE_SCHEDULER;
      }
      if (normalized.contains("timeline") || normalized.contains("dependency")) {
        return SCHEDULING_TIMELINE;
      }
      if (normalized.contains("booking") || normalized.contains("appointment")) {
        return SCHEDULING_BOOKING;
      }
      return SCHEDULING_AGENDA;
    }
    if (kind == BlueprintSampleKind.BULK) {
      if (normalized.contains("import") || normalized.contains("correction") || normalized.contains("exception")) {
        return BULK_QUEUE;
      }
      if (normalized.contains("export") || normalized.contains("builder")) {
        return BULK_BUILDER;
      }
      if (normalized.contains("monitor") || normalized.contains("status center")) {
        return BULK_MONITOR;
      }
      if (normalized.contains("migration") || normalized.contains("cleanup")) {
        return BULK_MIGRATION;
      }
      return BULK_MONITOR;
    }
    if (normalized.contains("permission matrix") || normalized.contains("feature flag")) {
      return ADMINISTRATION_MATRIX;
    }
    if (normalized.contains("policy") || normalized.contains("api key") || normalized.contains("integration")) {
      return ADMINISTRATION_POLICY;
    }
    if (normalized.contains("comparison") || normalized.contains("configuration comparison")) {
      return ADMINISTRATION_COMPARISON;
    }
    if (normalized.contains("directory") || normalized.contains("organization") || normalized.contains("tenant")) {
      return ADMINISTRATION_DIRECTORY;
    }
    if (normalized.contains("settings")) {
      return ADMINISTRATION_SETTINGS;
    }
    if (normalized.contains("audit")) {
      return AUDIT_TABLE;
    }
    if (normalized.contains("security event")) {
      return ADMINISTRATION_EVENT;
    }
    if (normalized.contains("document library") || normalized.contains("knowledge base") || normalized.contains("browser")) {
      return CONTENT_LIBRARY;
    }
    if (normalized.contains("comment") || normalized.contains("collaboration")) {
      return CONTENT_COLLABORATION;
    }
    if (normalized.contains("composer") || normalized.contains("rich content") || normalized.contains("editor")) {
      return normalized.contains("versioned") ? CONTENT_VERSIONED : CONTENT_COMPOSER;
    }
    if (normalized.contains("upload") || normalized.contains("processing")) {
      return CONTENT_UPLOAD;
    }
    if (normalized.contains("message") || normalized.contains("broadcast")) {
      return CONTENT_MESSAGE;
    }
    if (normalized.contains("saved view") || normalized.contains("saved filter")) {
      return SAVED_VIEW_DASHBOARD;
    }
    if (normalized.contains("drill") || normalized.contains("analytics")) {
      return DASHBOARD_DRILLDOWN;
    }
    if (normalized.contains("kpi") || normalized.contains("portfolio") || normalized.contains("productivity")) {
      return DASHBOARD_KPI;
    }
    if (normalized.contains("commentary") || normalized.contains("annotation")) {
      return DASHBOARD_COMMENTARY;
    }
    if (normalized.contains("command center") || normalized.contains("operational")) {
      return DASHBOARD_OPERATIONAL;
    }
    if (normalized.contains("wizard") || normalized.contains("stepped")) {
      return STEPPER_FORM;
    }
    if (normalized.contains("repeatable") || normalized.contains("collection")) {
      return FORM_REPEATABLE;
    }
    if (normalized.contains("conditional")) {
      return FORM_CONDITIONAL;
    }
    if (normalized.contains("preview") || normalized.contains("configuration")) {
      return FORM_PREVIEW;
    }
    if (normalized.contains("multi-section") || normalized.contains("two-column")) {
      return FORM_SECTIONED;
    }
    if (normalized.contains("import") || normalized.contains("correction") || normalized.contains("exception")) {
      return BULK_QUEUE;
    }
    if (normalized.contains("export") || normalized.contains("builder")) {
      return BULK_BUILDER;
    }
    if (normalized.contains("monitor") || normalized.contains("status center")) {
      return BULK_MONITOR;
    }
    if (normalized.contains("migration") || normalized.contains("cleanup")) {
      return BULK_MIGRATION;
    }
    if (normalized.contains("triage") || normalized.contains("incident")) {
      return OPERATIONS_TRIAGE;
    }
    if (normalized.contains("log")) {
      return OPERATIONS_LOG;
    }
    if (normalized.contains("health") || normalized.contains("integration monitor")) {
      return OPERATIONS_HEALTH;
    }
    if (normalized.contains("reconciliation") || normalized.contains("transaction")) {
      return OPERATIONS_RECONCILIATION;
    }
    if (normalized.contains("checklist") || normalized.contains("inspection")) {
      return OPERATIONS_CHECKLIST;
    }
    if (normalized.contains("pivot") || normalized.contains("ad hoc")) {
      return PIVOT_ANALYSIS;
    }
    if (normalized.contains("report builder")) {
      return REPORT_BUILDER;
    }
    if (normalized.contains("parameter")) {
      return REPORT_PARAMETERS;
    }
    if (normalized.contains("time series")) {
      return REPORT_TIMESERIES;
    }
    if (normalized.contains("map") || normalized.contains("geographic")) {
      return REPORT_MAP;
    }
    if (normalized.contains("metric") || normalized.contains("quality")) {
      return REPORT_GOVERNANCE;
    }
    if (normalized.contains("calendar") || normalized.contains("agenda")) {
      return SCHEDULING_CALENDAR;
    }
    if (normalized.contains("resource") || normalized.contains("capacity") || normalized.contains("shift")) {
      return RESOURCE_SCHEDULER;
    }
    if (normalized.contains("timeline") || normalized.contains("dependency")) {
      return SCHEDULING_TIMELINE;
    }
    if (normalized.contains("booking") || normalized.contains("appointment")) {
      return SCHEDULING_BOOKING;
    }
    if (normalized.contains("recurring") || normalized.contains("schedule")) {
      return SCHEDULING_AGENDA;
    }
    if (normalized.contains("dialog editor")) {
      return CRUD_DIALOG_LIST;
    }
    if (normalized.contains("side panel editor") || normalized.contains("persistent")) {
      return CRUD_SIDE_PANEL;
    }
    if (normalized.contains("inline") || normalized.contains("editable table")) {
      return CRUD_INLINE_TABLE;
    }
    if (normalized.contains("card grid")) {
      return CRUD_CARD_GRID;
    }
    if (normalized.contains("faceted") || normalized.contains("catalog")) {
      return CRUD_FACETED;
    }
    if (normalized.contains("comparison") || normalized.contains("compare")) {
      return CRUD_COMPARE;
    }
    if (normalized.contains("row expansion") || normalized.contains("expand")) {
      return CRUD_EXPANDABLE;
    }
    if (normalized.contains("search") || normalized.contains("directory") || normalized.contains("registry")) {
      return CRUD_SEARCH;
    }
    if (normalized.contains("hierarchical") || normalized.contains("hierarchy")) {
      return DETAIL_HIERARCHY;
    }
    if (normalized.contains("activity timeline")) {
      return DETAIL_TIMELINE;
    }
    if (normalized.contains("inspector")) {
      return DETAIL_INSPECTOR;
    }
    if (normalized.contains("comparison") || normalized.contains("compare")) {
      return DETAIL_COMPARE;
    }
    if (normalized.contains("preview") || normalized.contains("edit modes")) {
      return DETAIL_PREVIEW_EDIT;
    }
    if (kind == BlueprintSampleKind.DETAIL) {
      return DETAIL_RECORD;
    }
    if (normalized.contains("empty")) {
      return STATE_EMPTY;
    }
    if (normalized.contains("error") || normalized.contains("recovery")) {
      return STATE_ERROR;
    }
    if (normalized.contains("loading") || normalized.contains("progressive")) {
      return STATE_LOADING;
    }
    if (normalized.contains("offline") || normalized.contains("reconnecting")) {
      return OFFLINE_STATE;
    }
    if (normalized.contains("conflict")) {
      return STATE_CONFLICT;
    }
    if (normalized.contains("first-run") || normalized.contains("guided")) {
      return STATE_ONBOARDING;
    }
    if (normalized.contains("read-only") || normalized.contains("permission")) {
      return STATE_READONLY;
    }
    if (normalized.contains("unsaved")) {
      return STATE_UNSAVED;
    }
    if (normalized.contains("print") || normalized.contains("export-oriented")) {
      return STATE_PRINT;
    }
    if (normalized.contains("kanban")) {
      return KANBAN;
    }
    if (normalized.contains("queue") || normalized.contains("inbox")) {
      return WORKFLOW_QUEUE;
    }
    if (normalized.contains("checklist")) {
      return WORKFLOW_CHECKLIST;
    }
    if (normalized.contains("timeline") || normalized.contains("milestone")) {
      return WORKFLOW_TIMELINE;
    }
    if (normalized.contains("approval") || normalized.contains("request")) {
      return WORKFLOW_APPROVAL;
    }
    if (normalized.contains("matrix")) {
      return WORKFLOW_MATRIX;
    }
    if (normalized.contains("case")) {
      return WORKFLOW_CASE;
    }
    if (normalized.contains("sla") || normalized.contains("escalation")) {
      return WORKFLOW_SLA;
    }
    return fallback(kind, normalized);
  }

  private static BlueprintComposition fallback(BlueprintSampleKind kind, String title) {
    switch (kind) {
      case ADMINISTRATION:
        return ADMINISTRATION_SETTINGS;
      case CONTENT:
        return CONTENT_LIBRARY;
      case DASHBOARD:
        return DASHBOARD_KPI;
      case FORM:
        return FORM_SECTIONED;
      case BULK:
        return BULK_MONITOR;
      case OPERATIONS:
        return OPERATIONS_HEALTH;
      case REPORT:
        return REPORT_BUILDER;
      case SCHEDULING:
        return SCHEDULING_AGENDA;
      case CRUD:
        return title.contains("long") ? CRUD_SIDE_PANEL : CRUD_DIALOG_LIST;
      case DETAIL:
        return DETAIL_RECORD;
      case STATE:
        return STATE_LOADING;
      case WORKFLOW:
        return WORKFLOW_QUEUE;
      default:
        return CRUD_DIALOG_LIST;
    }
  }
}
