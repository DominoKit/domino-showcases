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
import org.dominokit.demo.samples.presenters.datatable.BrixEmptyStateTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.EmptyStateTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.EmptyStateTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.emptystate.BrixEmptyStateTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = EmptyStateTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixEmptyStateTablePresenterModule_.class,
        BrixEmptyStateTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EmptyStateTableComponent
    extends IsBrixComponent, HasPresenterProvider<EmptyStateTablePresenterProvider> {

  ComponentProvider<EmptyStateTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EmptyStateTableComponent newInstance() {
          return DaggerEmptyStateTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
