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
import org.dominokit.demo.samples.presenters.datatable.BrixTableHeaderBarPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.TableHeaderBarPresenter;
import org.dominokit.demo.samples.presenters.datatable.TableHeaderBarPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.header.BrixTableHeaderBarViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TableHeaderBarPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTableHeaderBarPresenterModule_.class,
        BrixTableHeaderBarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableHeaderBarComponent
    extends IsBrixComponent, HasPresenterProvider<TableHeaderBarPresenterProvider> {

  ComponentProvider<TableHeaderBarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableHeaderBarComponent newInstance() {
          return DaggerTableHeaderBarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
