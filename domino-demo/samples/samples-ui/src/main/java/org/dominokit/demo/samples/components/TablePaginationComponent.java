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
import org.dominokit.demo.samples.presenters.datatable.BrixTablePaginationPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.TablePaginationPresenter;
import org.dominokit.demo.samples.presenters.datatable.TablePaginationPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.pagination.BrixTablePaginationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TablePaginationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTablePaginationPresenterModule_.class,
        BrixTablePaginationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TablePaginationComponent
    extends IsBrixComponent, HasPresenterProvider<TablePaginationPresenterProvider> {

  ComponentProvider<TablePaginationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TablePaginationComponent newInstance() {
          return DaggerTablePaginationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
