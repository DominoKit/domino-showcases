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
import org.dominokit.demo.samples.presenters.datatable.BrixFixedDataTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.FixedDataTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.FixedDataTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.fixed.BrixFixedDataTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FixedDataTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFixedDataTablePresenterModule_.class,
        BrixFixedDataTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FixedDataTableComponent
    extends IsBrixComponent, HasPresenterProvider<FixedDataTablePresenterProvider> {

  ComponentProvider<FixedDataTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FixedDataTableComponent newInstance() {
          return DaggerFixedDataTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
