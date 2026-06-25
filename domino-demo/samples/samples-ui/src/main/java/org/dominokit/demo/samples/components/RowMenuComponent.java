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
import org.dominokit.demo.samples.presenters.datatable.BrixRowMenuPresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.RowMenuPresenter;
import org.dominokit.demo.samples.presenters.datatable.RowMenuPresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.menu.BrixRowMenuViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RowMenuPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRowMenuPresenterModule_.class,
        BrixRowMenuViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RowMenuComponent
    extends IsBrixComponent, HasPresenterProvider<RowMenuPresenterProvider> {

  ComponentProvider<RowMenuComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RowMenuComponent newInstance() {
          return DaggerRowMenuComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
