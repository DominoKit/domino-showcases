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
import org.dominokit.demo.samples.presenters.datatable.BrixTableRowMarkerPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.TableRowMarkerPresenter;
import org.dominokit.demo.samples.presenters.datatable.TableRowMarkerPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.marker.BrixTableRowMarkerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TableRowMarkerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTableRowMarkerPresenterModule_.class,
        BrixTableRowMarkerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TableRowMarkerComponent
    extends IsBrixComponent, HasPresenterProvider<TableRowMarkerPresenterProvider> {

  ComponentProvider<TableRowMarkerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TableRowMarkerComponent newInstance() {
          return DaggerTableRowMarkerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
