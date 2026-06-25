package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixAlertsProxyModule_;
import org.dominokit.pages.presenters.samples.components.AlertsProxy;
import org.dominokit.pages.presenters.samples.components.AlertsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.alerts.BrixAlertsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = AlertsProxy.class)
@Component(
    modules = {
        BrixAlertsProxyModule_.class,
        BrixAlertsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface AlertsComponent
    extends IsBrixComponent, HasPresenterProvider<AlertsProxyProvider> {

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
