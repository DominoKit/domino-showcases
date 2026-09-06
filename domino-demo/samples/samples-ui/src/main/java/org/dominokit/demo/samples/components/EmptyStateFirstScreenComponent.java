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
import org.dominokit.demo.samples.presenters.blueprints.BrixEmptyStateFirstScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.EmptyStateFirstScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.EmptyStateFirstScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.specialStatesAndConstrainedCompositions.BrixEmptyStateFirstScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = EmptyStateFirstScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixEmptyStateFirstScreenPresenterModule_.class,
        BrixEmptyStateFirstScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EmptyStateFirstScreenComponent
    extends IsBrixComponent, HasPresenterProvider<EmptyStateFirstScreenPresenterProvider> {

  ComponentProvider<EmptyStateFirstScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EmptyStateFirstScreenComponent newInstance() {
          return DaggerEmptyStateFirstScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
