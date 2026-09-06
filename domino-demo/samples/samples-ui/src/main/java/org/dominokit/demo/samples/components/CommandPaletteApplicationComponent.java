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
import org.dominokit.demo.samples.presenters.blueprints.BrixCommandPaletteApplicationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.CommandPaletteApplicationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.CommandPaletteApplicationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation.BrixCommandPaletteApplicationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CommandPaletteApplicationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCommandPaletteApplicationPresenterModule_.class,
        BrixCommandPaletteApplicationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CommandPaletteApplicationComponent
    extends IsBrixComponent, HasPresenterProvider<CommandPaletteApplicationPresenterProvider> {

  ComponentProvider<CommandPaletteApplicationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CommandPaletteApplicationComponent newInstance() {
          return DaggerCommandPaletteApplicationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
