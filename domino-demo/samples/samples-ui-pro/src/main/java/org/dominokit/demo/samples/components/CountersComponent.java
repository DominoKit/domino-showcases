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
import org.dominokit.demo.samples.presenters.components.BrixCountersPresenterModule_;
import org.dominokit.demo.samples.presenters.components.CountersPresenter;
import org.dominokit.demo.samples.presenters.components.CountersPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.counters.BrixCountersViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CountersPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCountersPresenterModule_.class,
        BrixCountersViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CountersComponent
    extends IsBrixComponent, HasPresenterProvider<CountersPresenterProvider> {

  ComponentProvider<CountersComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CountersComponent newInstance() {
          return DaggerCountersComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
