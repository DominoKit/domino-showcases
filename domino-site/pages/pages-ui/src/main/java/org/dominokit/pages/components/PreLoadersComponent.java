package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixPreLoadersProxyModule_;
import org.dominokit.pages.presenters.samples.components.PreLoadersProxy;
import org.dominokit.pages.presenters.samples.components.PreLoadersProxyProvider;
import org.dominokit.pages.ui.views.samples.components.preloaders.BrixPreLoadersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = PreLoadersProxy.class)
@Component(
    modules = {
        BrixPreLoadersProxyModule_.class,
        BrixPreLoadersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PreLoadersComponent
    extends IsBrixComponent, HasPresenterProvider<PreLoadersProxyProvider> {

  ComponentProvider<PreLoadersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PreLoadersComponent newInstance() {
          return DaggerPreLoadersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
