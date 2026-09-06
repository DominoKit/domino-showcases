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
import org.dominokit.demo.samples.presenters.blueprints.BrixOperationsMonitoringAndExceptionHandlingPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.OperationsMonitoringAndExceptionHandlingPresenter;
import org.dominokit.demo.samples.presenters.blueprints.OperationsMonitoringAndExceptionHandlingPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixOperationsMonitoringAndExceptionHandlingViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = OperationsMonitoringAndExceptionHandlingPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixOperationsMonitoringAndExceptionHandlingPresenterModule_.class,
      BrixOperationsMonitoringAndExceptionHandlingViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface OperationsMonitoringAndExceptionHandlingComponent
    extends IsBrixComponent, HasPresenterProvider<OperationsMonitoringAndExceptionHandlingPresenterProvider> {

  ComponentProvider<OperationsMonitoringAndExceptionHandlingComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected OperationsMonitoringAndExceptionHandlingComponent newInstance() {
          return DaggerOperationsMonitoringAndExceptionHandlingComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
