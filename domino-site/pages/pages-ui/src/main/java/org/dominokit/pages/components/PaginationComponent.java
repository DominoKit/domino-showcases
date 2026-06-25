package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixPaginationProxyModule_;
import org.dominokit.pages.presenters.samples.components.PaginationProxy;
import org.dominokit.pages.presenters.samples.components.PaginationProxyProvider;
import org.dominokit.pages.ui.views.samples.components.pagination.BrixPaginationViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = PaginationProxy.class)
@Component(
    modules = {
        BrixPaginationProxyModule_.class,
        BrixPaginationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PaginationComponent
    extends IsBrixComponent, HasPresenterProvider<PaginationProxyProvider> {

  ComponentProvider<PaginationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PaginationComponent newInstance() {
          return DaggerPaginationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
