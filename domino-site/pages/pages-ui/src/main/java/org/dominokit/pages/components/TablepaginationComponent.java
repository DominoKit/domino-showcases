package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixTablepaginationProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.TablepaginationProxy;
import org.dominokit.pages.presenters.samples.datatable.TablepaginationProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.pagination.BrixTablePaginationViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TablepaginationProxy.class)
@Component(
    modules = {
        BrixTablepaginationProxyModule_.class,
        BrixTablePaginationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TablepaginationComponent
    extends IsBrixComponent, HasPresenterProvider<TablepaginationProxyProvider> {

  ComponentProvider<TablepaginationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TablepaginationComponent newInstance() {
          return DaggerTablepaginationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
