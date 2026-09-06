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
import org.dominokit.demo.samples.presenters.blueprints.BrixAlertTriageScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.AlertTriageScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.AlertTriageScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixAlertTriageScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AlertTriageScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAlertTriageScreenPresenterModule_.class,
        BrixAlertTriageScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AlertTriageScreenComponent
    extends IsBrixComponent, HasPresenterProvider<AlertTriageScreenPresenterProvider> {

  ComponentProvider<AlertTriageScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AlertTriageScreenComponent newInstance() {
          return DaggerAlertTriageScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
