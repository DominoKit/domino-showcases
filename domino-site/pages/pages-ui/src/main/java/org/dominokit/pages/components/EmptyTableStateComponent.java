package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixEmptyTableStateProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.EmptyTableStateProxy;
import org.dominokit.pages.presenters.samples.datatable.EmptyTableStateProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.emptystate.BrixEmptyStateTableViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = EmptyTableStateProxy.class)
@Component(
    modules = {
        BrixEmptyTableStateProxyModule_.class,
        BrixEmptyStateTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EmptyTableStateComponent
    extends IsBrixComponent, HasPresenterProvider<EmptyTableStateProxyProvider> {

  ComponentProvider<EmptyTableStateComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EmptyTableStateComponent newInstance() {
          return DaggerEmptyTableStateComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
