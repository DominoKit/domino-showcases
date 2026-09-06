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
import org.dominokit.demo.samples.presenters.blueprints.BrixServiceHealthDashboardPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ServiceHealthDashboardPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ServiceHealthDashboardPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixServiceHealthDashboardViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ServiceHealthDashboardPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixServiceHealthDashboardPresenterModule_.class,
        BrixServiceHealthDashboardViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ServiceHealthDashboardComponent
    extends IsBrixComponent, HasPresenterProvider<ServiceHealthDashboardPresenterProvider> {

  ComponentProvider<ServiceHealthDashboardComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ServiceHealthDashboardComponent newInstance() {
          return DaggerServiceHealthDashboardComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
