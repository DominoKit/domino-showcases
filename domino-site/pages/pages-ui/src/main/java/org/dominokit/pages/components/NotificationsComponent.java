package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixNotificationsProxyModule_;
import org.dominokit.pages.presenters.samples.components.NotificationsProxy;
import org.dominokit.pages.presenters.samples.components.NotificationsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.notifications.BrixNotificationsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = NotificationsProxy.class)
@Component(
    modules = {
        BrixNotificationsProxyModule_.class,
        BrixNotificationsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface NotificationsComponent
    extends IsBrixComponent, HasPresenterProvider<NotificationsProxyProvider> {

  ComponentProvider<NotificationsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected NotificationsComponent newInstance() {
          return DaggerNotificationsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
