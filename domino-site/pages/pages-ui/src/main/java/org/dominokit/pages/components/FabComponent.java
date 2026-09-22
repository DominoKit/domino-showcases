package org.dominokit.pages.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.pages.presenters.samples.components.BrixFabProxyModule_;
import org.dominokit.pages.presenters.samples.components.FabProxy;
import org.dominokit.pages.presenters.samples.components.FabProxyProvider;
import org.dominokit.pages.ui.views.samples.components.fab.BrixFabViewModule_;

@BrixComponent(presenter = FabProxy.class)
@Component(
    modules = {BrixFabProxyModule_.class, BrixFabViewModule_.class, CoreComponentModule.class})
@Singleton
public interface FabComponent extends IsBrixComponent, HasPresenterProvider<FabProxyProvider> {

  ComponentProvider<FabComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FabComponent newInstance() {
          return DaggerFabComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
