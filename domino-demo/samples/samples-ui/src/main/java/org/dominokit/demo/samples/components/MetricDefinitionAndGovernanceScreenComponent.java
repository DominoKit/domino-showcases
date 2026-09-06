package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.blueprints.BrixMetricDefinitionAndGovernanceScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.MetricDefinitionAndGovernanceScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.MetricDefinitionAndGovernanceScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.reportingAnalyticsAndDataExploration.BrixMetricDefinitionAndGovernanceScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MetricDefinitionAndGovernanceScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMetricDefinitionAndGovernanceScreenPresenterModule_.class,
        BrixMetricDefinitionAndGovernanceScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MetricDefinitionAndGovernanceScreenComponent
    extends IsBrixComponent, HasPresenterProvider<MetricDefinitionAndGovernanceScreenPresenterProvider> {

  ComponentProvider<MetricDefinitionAndGovernanceScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MetricDefinitionAndGovernanceScreenComponent newInstance() {
          return DaggerMetricDefinitionAndGovernanceScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
