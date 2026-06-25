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
import org.dominokit.demo.samples.presenters.datatable.BrixEagerTreeTablePresenterModule_;
import org.dominokit.demo.samples.presenters.datatable.EagerTreeTablePresenter;
import org.dominokit.demo.samples.presenters.datatable.EagerTreeTablePresenterProvider;
import org.dominokit.demo.samples.ui.views.datatable.tree.BrixEagerTreeTableViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = EagerTreeTablePresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixEagerTreeTablePresenterModule_.class,
        BrixEagerTreeTableViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface EagerTreeTableComponent
    extends IsBrixComponent, HasPresenterProvider<EagerTreeTablePresenterProvider> {

  ComponentProvider<EagerTreeTableComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected EagerTreeTableComponent newInstance() {
          return DaggerEagerTreeTableComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
