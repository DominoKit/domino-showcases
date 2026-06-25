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
import org.dominokit.demo.samples.presenters.components.BrixPreLoadersPresenterModule_;
import org.dominokit.demo.samples.presenters.components.PreLoadersPresenter;
import org.dominokit.demo.samples.presenters.components.PreLoadersPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.preloaders.BrixPreLoadersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = PreLoadersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixPreLoadersPresenterModule_.class,
        BrixPreLoadersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PreLoadersComponent
    extends IsBrixComponent, HasPresenterProvider<PreLoadersPresenterProvider> {

  ComponentProvider<PreLoadersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PreLoadersComponent newInstance() {
          return DaggerPreLoadersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
