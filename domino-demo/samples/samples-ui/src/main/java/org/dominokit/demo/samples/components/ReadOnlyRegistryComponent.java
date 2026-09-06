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
import org.dominokit.demo.samples.presenters.blueprints.BrixReadOnlyRegistryPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ReadOnlyRegistryPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ReadOnlyRegistryPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.searchListAndCrudScreens.BrixReadOnlyRegistryViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ReadOnlyRegistryPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixReadOnlyRegistryPresenterModule_.class,
        BrixReadOnlyRegistryViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ReadOnlyRegistryComponent
    extends IsBrixComponent, HasPresenterProvider<ReadOnlyRegistryPresenterProvider> {

  ComponentProvider<ReadOnlyRegistryComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ReadOnlyRegistryComponent newInstance() {
          return DaggerReadOnlyRegistryComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
