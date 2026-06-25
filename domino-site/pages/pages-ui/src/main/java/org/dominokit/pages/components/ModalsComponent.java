package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixModalsProxyModule_;
import org.dominokit.pages.presenters.samples.components.ModalsProxy;
import org.dominokit.pages.presenters.samples.components.ModalsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.modals.BrixModalsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ModalsProxy.class)
@Component(
    modules = {
        BrixModalsProxyModule_.class,
        BrixModalsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ModalsComponent
    extends IsBrixComponent, HasPresenterProvider<ModalsProxyProvider> {

  ComponentProvider<ModalsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ModalsComponent newInstance() {
          return DaggerModalsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
