package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixSlidersProxyModule_;
import org.dominokit.pages.presenters.samples.components.SlidersProxy;
import org.dominokit.pages.presenters.samples.components.SlidersProxyProvider;
import org.dominokit.pages.ui.views.samples.components.sliders.BrixSlidersViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = SlidersProxy.class)
@Component(
    modules = {
        BrixSlidersProxyModule_.class,
        BrixSlidersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SlidersComponent
    extends IsBrixComponent, HasPresenterProvider<SlidersProxyProvider> {

  ComponentProvider<SlidersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SlidersComponent newInstance() {
          return DaggerSlidersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
