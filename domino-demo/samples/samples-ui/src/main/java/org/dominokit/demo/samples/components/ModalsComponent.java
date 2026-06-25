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
import org.dominokit.demo.samples.presenters.components.BrixModalsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ModalsPresenter;
import org.dominokit.demo.samples.presenters.components.ModalsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.modals.BrixModalsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ModalsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixModalsPresenterModule_.class,
        BrixModalsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ModalsComponent
    extends IsBrixComponent, HasPresenterProvider<ModalsPresenterProvider> {

  ComponentProvider<ModalsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ModalsComponent newInstance() {
          return DaggerModalsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
