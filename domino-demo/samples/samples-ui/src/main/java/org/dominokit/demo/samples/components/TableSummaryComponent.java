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
import org.dominokit.demo.samples.presenters.datatable.BrixTableSummaryPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.TableSummaryPresenter;
import org.dominokit.demo.samples.presenters.datatable.TableSummaryPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.summary.BrixTableSummaryViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TableSummaryPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTableSummaryPresenterModule_.class,
        BrixTableSummaryViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableSummaryComponent
    extends IsBrixComponent, HasPresenterProvider<TableSummaryPresenterProvider> {

  ComponentProvider<TableSummaryComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableSummaryComponent newInstance() {
          return DaggerTableSummaryComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
