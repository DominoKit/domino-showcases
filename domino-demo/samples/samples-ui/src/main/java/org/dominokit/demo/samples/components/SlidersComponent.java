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
import org.dominokit.demo.samples.presenters.components.BrixSlidersPresenterModule_;
import org.dominokit.demo.samples.presenters.components.SlidersPresenter;
import org.dominokit.demo.samples.presenters.components.SlidersPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.sliders.BrixSlidersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SlidersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSlidersPresenterModule_.class,
        BrixSlidersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SlidersComponent
    extends IsBrixComponent, HasPresenterProvider<SlidersPresenterProvider> {

  ComponentProvider<SlidersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SlidersComponent newInstance() {
          return DaggerSlidersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
