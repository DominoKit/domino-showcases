package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.operationsMonitoringAndExceptionHandling.JobAndBatchMonitorView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(JobAndBatchMonitorPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class JobAndBatchMonitorPresenter extends ChildPresenter<ShellPresenter, JobAndBatchMonitorView>
    implements JobAndBatchMonitorView.JobAndBatchMonitorUiHandlers {

  public static final String ROUTE = "blueprints/operations-monitoring-and-exception-handling/job-and-batch-monitor";
}
