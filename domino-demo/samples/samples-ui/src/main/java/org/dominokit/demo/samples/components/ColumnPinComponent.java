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
import org.dominokit.demo.samples.presenters.datatable.BrixColumnPinPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.ColumnPinPresenter;
import org.dominokit.demo.samples.presenters.datatable.ColumnPinPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.columnpin.BrixColumnPinViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ColumnPinPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixColumnPinPresenterModule_.class,
        BrixColumnPinViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ColumnPinComponent
    extends IsBrixComponent, HasPresenterProvider<ColumnPinPresenterProvider> {

  ComponentProvider<ColumnPinComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ColumnPinComponent newInstance() {
          return DaggerColumnPinComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
