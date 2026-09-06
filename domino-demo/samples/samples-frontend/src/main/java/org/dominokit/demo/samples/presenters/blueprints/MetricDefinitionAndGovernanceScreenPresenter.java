package org.dominokit.demo.samples.presenters.blueprints;

import org.dominokit.brix.annotations.BrixPresenter;
import org.dominokit.brix.annotations.BrixRoute;
import org.dominokit.brix.annotations.BrixSlot;
import org.dominokit.brix.api.ChildPresenter;
import org.dominokit.demo.samples.views.blueprints.reportingAnalyticsAndDataExploration.MetricDefinitionAndGovernanceScreenView;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;

@BrixPresenter
@BrixRoute(MetricDefinitionAndGovernanceScreenPresenter.ROUTE)
@BrixSlot(ShellPresenter.CONTENT_SLOT)
public abstract class MetricDefinitionAndGovernanceScreenPresenter extends ChildPresenter<ShellPresenter, MetricDefinitionAndGovernanceScreenView>
    implements MetricDefinitionAndGovernanceScreenView.MetricDefinitionAndGovernanceScreenUiHandlers {

  public static final String ROUTE = "blueprints/reporting-analytics-and-data-exploration/metric-definition-and-governance-screen";
}
