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
import org.dominokit.demo.samples.presenters.components.BrixNotificationsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.NotificationsPresenter;
import org.dominokit.demo.samples.presenters.components.NotificationsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.notifications.BrixNotificationsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = NotificationsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixNotificationsPresenterModule_.class,
        BrixNotificationsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface NotificationsComponent
    extends IsBrixComponent, HasPresenterProvider<NotificationsPresenterProvider> {

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
