package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixCountersProxyModule_;
import org.dominokit.pages.presenters.samples.components.CountersProxy;
import org.dominokit.pages.presenters.samples.components.CountersProxyProvider;
import org.dominokit.pages.ui.views.samples.components.counters.BrixCountersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = CountersProxy.class)
@Component(
    modules = {
        BrixCountersProxyModule_.class,
        BrixCountersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CountersComponent
    extends IsBrixComponent, HasPresenterProvider<CountersProxyProvider> {

  ComponentProvider<CountersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CountersComponent newInstance() {
          return DaggerCountersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
