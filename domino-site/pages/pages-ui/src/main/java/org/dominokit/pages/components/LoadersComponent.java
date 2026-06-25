package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixLoadersProxyModule_;
import org.dominokit.pages.presenters.samples.components.LoadersProxy;
import org.dominokit.pages.presenters.samples.components.LoadersProxyProvider;
import org.dominokit.pages.ui.views.samples.components.loaders.BrixLoadersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = LoadersProxy.class)
@Component(
    modules = {
        BrixLoadersProxyModule_.class,
        BrixLoadersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LoadersComponent
    extends IsBrixComponent, HasPresenterProvider<LoadersProxyProvider> {

  ComponentProvider<LoadersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LoadersComponent newInstance() {
          return DaggerLoadersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
