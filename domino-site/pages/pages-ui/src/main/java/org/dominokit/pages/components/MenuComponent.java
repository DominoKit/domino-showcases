package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixMenuProxyModule_;
import org.dominokit.pages.presenters.samples.components.MenuProxy;
import org.dominokit.pages.presenters.samples.components.MenuProxyProvider;
import org.dominokit.pages.ui.views.samples.components.menu.BrixMenuViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = MenuProxy.class)
@Component(
    modules = {
        BrixMenuProxyModule_.class,
        BrixMenuViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MenuComponent
    extends IsBrixComponent, HasPresenterProvider<MenuProxyProvider> {

  ComponentProvider<MenuComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MenuComponent newInstance() {
          return DaggerMenuComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
