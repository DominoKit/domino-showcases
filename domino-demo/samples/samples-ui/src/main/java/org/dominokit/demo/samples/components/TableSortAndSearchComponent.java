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
import org.dominokit.demo.samples.presenters.datatable.BrixTableSortAndSearchPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.TableSortAndSearchPresenter;
import org.dominokit.demo.samples.presenters.datatable.TableSortAndSearchPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.sortsearch.BrixTableSortAndSearchViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TableSortAndSearchPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTableSortAndSearchPresenterModule_.class,
        BrixTableSortAndSearchViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableSortAndSearchComponent
    extends IsBrixComponent, HasPresenterProvider<TableSortAndSearchPresenterProvider> {

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
