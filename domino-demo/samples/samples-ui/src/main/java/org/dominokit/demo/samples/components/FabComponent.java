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
import org.dominokit.demo.samples.presenters.components.BrixFabPresenterModule_;
import org.dominokit.demo.samples.presenters.components.FabPresenter;
import org.dominokit.demo.samples.presenters.components.FabPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.fab.BrixFabViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FabPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixFabPresenterModule_.class,
      BrixFabViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface FabComponent
    extends IsBrixComponent, HasPresenterProvider<FabPresenterProvider> {

  ComponentProvider<FabComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FabComponent newInstance() {
          return DaggerFabComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
