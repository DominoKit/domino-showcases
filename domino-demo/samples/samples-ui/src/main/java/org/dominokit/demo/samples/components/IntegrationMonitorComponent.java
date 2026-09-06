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
import org.dominokit.demo.samples.presenters.blueprints.BrixIntegrationMonitorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.IntegrationMonitorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.IntegrationMonitorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixIntegrationMonitorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = IntegrationMonitorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixIntegrationMonitorPresenterModule_.class,
        BrixIntegrationMonitorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface IntegrationMonitorComponent
    extends IsBrixComponent, HasPresenterProvider<IntegrationMonitorPresenterProvider> {

  ComponentProvider<IntegrationMonitorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected IntegrationMonitorComponent newInstance() {
          return DaggerIntegrationMonitorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
