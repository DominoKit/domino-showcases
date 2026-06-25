package org.dominokit.demo.samples.components;

import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;
import org.dominokit.demo.samples.presenters.components.BrixWavesPresenterModule_;
import org.dominokit.demo.samples.presenters.components.WavesPresenter;
import org.dominokit.demo.samples.presenters.components.WavesPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.waves.BrixWavesViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = WavesPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixWavesPresenterModule_.class,
        BrixWavesViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface WavesComponent
    extends IsBrixComponent, HasPresenterProvider<WavesPresenterProvider> {

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
