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
import org.dominokit.demo.samples.presenters.forms.BrixSteppersPresenterModule_;
import org.dominokit.demo.samples.presenters.forms.SteppersPresenter;
import org.dominokit.demo.samples.presenters.forms.SteppersPresenterProvider;
import org.dominokit.demo.samples.ui.views.forms.steppers.BrixSteppersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SteppersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSteppersPresenterModule_.class,
        BrixSteppersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SteppersComponent
    extends IsBrixComponent, HasPresenterProvider<SteppersPresenterProvider> {

  ComponentProvider<SteppersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SteppersComponent newInstance() {
          return DaggerSteppersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
