package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixNavBarProxyModule_;
import org.dominokit.pages.presenters.samples.components.NavBarProxy;
import org.dominokit.pages.presenters.samples.components.NavBarProxyProvider;
import org.dominokit.pages.ui.views.samples.components.navbar.BrixNavbarViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = NavBarProxy.class)
@Component(
    modules = {
        BrixNavBarProxyModule_.class,
        BrixNavbarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface NavBarComponent
    extends IsBrixComponent, HasPresenterProvider<NavBarProxyProvider> {

  ComponentProvider<NavBarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected NavBarComponent newInstance() {
          return DaggerNavBarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
