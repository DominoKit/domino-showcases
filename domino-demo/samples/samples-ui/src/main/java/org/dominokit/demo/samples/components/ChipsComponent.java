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
import org.dominokit.demo.samples.presenters.components.BrixChipsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ChipsPresenter;
import org.dominokit.demo.samples.presenters.components.ChipsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.chips.BrixChipsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ChipsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixChipsPresenterModule_.class,
        BrixChipsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ChipsComponent
    extends IsBrixComponent, HasPresenterProvider<ChipsPresenterProvider> {

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
