package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixWavesProxyModule_;
import org.dominokit.pages.presenters.samples.components.WavesProxy;
import org.dominokit.pages.presenters.samples.components.WavesProxyProvider;
import org.dominokit.pages.ui.views.samples.components.waves.BrixWavesViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = WavesProxy.class)
@Component(
    modules = {
        BrixWavesProxyModule_.class,
        BrixWavesViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface WavesComponent
    extends IsBrixComponent, HasPresenterProvider<WavesProxyProvider> {

  ComponentProvider<WavesComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected WavesComponent newInstance() {
          return DaggerWavesComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
