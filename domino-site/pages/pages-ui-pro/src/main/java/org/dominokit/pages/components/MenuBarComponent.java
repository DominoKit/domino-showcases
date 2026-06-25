package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixMenuBarProxyModule_;
import org.dominokit.pages.presenters.samples.components.MenuBarProxy;
import org.dominokit.pages.presenters.samples.components.MenuBarProxyProvider;
import org.dominokit.pages.ui.views.samples.components.menubar.BrixMenuBarViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = MenuBarProxy.class)
@Component(
    modules = {
        BrixMenuBarProxyModule_.class,
        BrixMenuBarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MenuBarComponent
    extends IsBrixComponent, HasPresenterProvider<MenuBarProxyProvider> {

  ComponentProvider<MenuBarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MenuBarComponent newInstance() {
          return DaggerMenuBarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
