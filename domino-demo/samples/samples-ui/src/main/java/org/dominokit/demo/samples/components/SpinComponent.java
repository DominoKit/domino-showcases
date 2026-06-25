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
import org.dominokit.demo.samples.presenters.components.BrixSpinPresenterModule_;
import org.dominokit.demo.samples.presenters.components.SpinPresenter;
import org.dominokit.demo.samples.presenters.components.SpinPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.spin.BrixSpinViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SpinPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSpinPresenterModule_.class,
        BrixSpinViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SpinComponent
    extends IsBrixComponent, HasPresenterProvider<SpinPresenterProvider> {

  ComponentProvider<SpinComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SpinComponent newInstance() {
          return DaggerSpinComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
