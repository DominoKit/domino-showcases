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
import org.dominokit.demo.samples.presenters.datatable.BrixBasicDataTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.BasicDataTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.BasicDataTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.basic.BrixBasicDataTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = BasicDataTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixBasicDataTablePresenterModule_.class,
        BrixBasicDataTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface BasicDataTableComponent
    extends IsBrixComponent, HasPresenterProvider<BasicDataTablePresenterProvider> {

  ComponentProvider<BasicDataTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected BasicDataTableComponent newInstance() {
          return DaggerBasicDataTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
