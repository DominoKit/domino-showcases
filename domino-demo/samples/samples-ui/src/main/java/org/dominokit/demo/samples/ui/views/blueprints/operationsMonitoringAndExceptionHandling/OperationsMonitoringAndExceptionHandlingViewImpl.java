package org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_col;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_4;
import static org.dominokit.domino.ui.utils.Domino.dui_p_4;

import elemental2.dom.HTMLDivElement;
import javax.inject.Inject;
import org.dominokit.brix.annotations.UiView;
import org.dominokit.brix.impl.BrixView;
import org.dominokit.demo.samples.ui.components.SampleShowcase;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.OperationsMonitoringAndExceptionHandlingView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.ServiceHealthDashboardSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.IncidentManagementWorkspaceSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.JobAndBatchMonitorSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.IntegrationMonitorSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.AlertTriageScreenSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.LogExplorerSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.TransactionReconciliationScreenSample;
import org.dominokit.showcases.samples.blueprints.operations_monitoring_and_exception_handling.OperationalChecklistAndInspectionSample;

@UiView
public class OperationsMonitoringAndExceptionHandlingViewImpl extends BrixView<HTMLDivElement, OperationsMonitoringAndExceptionHandlingView.OperationsMonitoringAndExceptionHandlingUiHandlers>
    implements OperationsMonitoringAndExceptionHandlingView {

  private final DivElement root;

  @Inject
  public OperationsMonitoringAndExceptionHandlingViewImpl() {
    this.root = div()
        .addCss(dui_p_4, dui_flex, dui_flex_col, dui_gap_4)
        .appendChild(BlockHeader.create(
            "Operations, monitoring, and exception handling",
            "Catalog category with 8 independently navigable blueprint samples."))
            .appendChild(
                SampleShowcase.create(
                    "Service health dashboard",
                    "Layout: Service status cards, dependency map, incidents, latency/error charts, and recent deploys. Interaction: Operators filter services, inspect incidents, acknowledge alerts, and open runbooks. Variants: Executive health, engineering operations, or tenant-specific health.",
                    ServiceHealthDashboardSample.class,
                    ServiceHealthDashboardSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Incident management workspace",
                    "Layout: Incident header, severity/status, timeline, responders, communication log, and action checklist. Interaction: Responders assign roles, update status, add events, publish updates, and resolve/postmortem. Variants: War-room view, incident detail, or command-center split view.",
                    IncidentManagementWorkspaceSample.class,
                    IncidentManagementWorkspaceSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Job and batch monitor",
                    "Layout: Job list with status, schedule, duration, logs, retries, and run detail. Interaction: Users start, pause, retry, cancel, inspect logs, and compare runs. Variants: ETL jobs, scheduled reports, or background processing.",
                    JobAndBatchMonitorSample.class,
                    JobAndBatchMonitorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Integration monitor",
                    "Layout: Integration endpoints, message counts, latency, failures, and recent payloads appear in a monitoring workspace. Interaction: Users inspect failures, replay messages, pause/resume endpoints, and test connections. Variants: API integration, event stream, or file exchange.",
                    IntegrationMonitorSample.class,
                    IntegrationMonitorSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Alert triage screen",
                    "Layout: Alert queue with severity, source, age, owner, and a detail/evidence panel. Interaction: Users acknowledge, suppress, group, assign, escalate, and resolve alerts. Variants: Security, infrastructure, business-rule, or data-quality alerts.",
                    AlertTriageScreenSample.class,
                    AlertTriageScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Log explorer",
                    "Layout: Query/filter bar, time-series summary, log stream, and selected-entry detail. Interaction: Users search, refine queries, expand context, bookmark queries, and export results. Variants: Structured logs, application logs, or audit events.",
                    LogExplorerSample.class,
                    LogExplorerSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Transaction reconciliation screen",
                    "Layout: Matched, unmatched, and exception records are grouped with amount/date/reference summaries. Interaction: Users match records, split/merge candidates, accept differences, and post adjustments. Variants: Bank reconciliation, inventory reconciliation, or integration reconciliation.",
                    TransactionReconciliationScreenSample.class,
                    TransactionReconciliationScreenSample::create))
            .appendChild(
                SampleShowcase.create(
                    "Operational checklist and inspection",
                    "Layout: Asset/location summary, checklist sections, measurements, evidence, and sign-off area. Interaction: Users complete checks, record exceptions, attach photos/files, and sign or escalate. Variants: Field inspection, safety inspection, or opening/closing checklist.",
                    OperationalChecklistAndInspectionSample.class,
                    OperationalChecklistAndInspectionSample::create));
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
