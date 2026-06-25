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
import org.dominokit.demo.samples.presenters.components.AlertsPresenter;
import org.dominokit.demo.samples.presenters.components.AlertsPresenterProvider;
import org.dominokit.demo.samples.presenters.components.BrixAlertsPresenterModule_;
import org.dominokit.demo.samples.ui.views.components.alerts.BrixAlertsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = AlertsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixAlertsPresenterModule_.class,
        BrixAlertsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AlertsComponent
    extends IsBrixComponent, HasPresenterProvider<AlertsPresenterProvider> {

  ComponentProvider<AlertsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected AlertsComponent newInstance() {
          return DaggerAlertsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
