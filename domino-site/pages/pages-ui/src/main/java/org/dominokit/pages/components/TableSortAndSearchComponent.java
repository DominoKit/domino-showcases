package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.datatable.BrixTableSortAndSearchProxyModule_;
import org.dominokit.pages.presenters.samples.datatable.TableSortAndSearchProxy;
import org.dominokit.pages.presenters.samples.datatable.TableSortAndSearchProxyProvider;
import org.dominokit.pages.ui.views.samples.datatable.sortsearch.BrixTableSortAndSearchViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TableSortAndSearchProxy.class)
@Component(
    modules = {
        BrixTableSortAndSearchProxyModule_.class,
        BrixTableSortAndSearchViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableSortAndSearchComponent
    extends IsBrixComponent, HasPresenterProvider<TableSortAndSearchProxyProvider> {

  ComponentProvider<TableSortAndSearchComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableSortAndSearchComponent newInstance() {
          return DaggerTableSortAndSearchComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
