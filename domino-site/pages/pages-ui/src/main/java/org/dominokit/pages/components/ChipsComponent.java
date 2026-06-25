package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixChipsProxyModule_;
import org.dominokit.pages.presenters.samples.components.ChipsProxy;
import org.dominokit.pages.presenters.samples.components.ChipsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.chips.BrixChipsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ChipsProxy.class)
@Component(
    modules = {
        BrixChipsProxyModule_.class,
        BrixChipsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ChipsComponent
    extends IsBrixComponent, HasPresenterProvider<ChipsProxyProvider> {

  ComponentProvider<ChipsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ChipsComponent newInstance() {
          return DaggerChipsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
