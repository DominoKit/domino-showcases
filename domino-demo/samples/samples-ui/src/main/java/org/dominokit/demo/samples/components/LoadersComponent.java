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
import org.dominokit.demo.samples.presenters.components.BrixLoadersPresenterModule_;
import org.dominokit.demo.samples.presenters.components.LoadersPresenter;
import org.dominokit.demo.samples.presenters.components.LoadersPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.loaders.BrixLoadersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LoadersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLoadersPresenterModule_.class,
        BrixLoadersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LoadersComponent
    extends IsBrixComponent, HasPresenterProvider<LoadersPresenterProvider> {

  ComponentProvider<LoadersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LoadersComponent newInstance() {
          return DaggerLoadersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
