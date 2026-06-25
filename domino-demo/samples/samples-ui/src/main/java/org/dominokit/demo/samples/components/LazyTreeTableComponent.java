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
import org.dominokit.demo.samples.presenters.datatable.BrixLazyTreeTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.LazyTreeTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.LazyTreeTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.tree.BrixLazyTreeTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LazyTreeTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLazyTreeTablePresenterModule_.class,
        BrixLazyTreeTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LazyTreeTableComponent
    extends IsBrixComponent, HasPresenterProvider<LazyTreeTablePresenterProvider> {

  ComponentProvider<LazyTreeTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LazyTreeTableComponent newInstance() {
          return DaggerLazyTreeTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
