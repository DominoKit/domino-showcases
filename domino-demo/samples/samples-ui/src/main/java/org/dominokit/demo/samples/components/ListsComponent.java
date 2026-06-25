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
import org.dominokit.demo.samples.presenters.components.BrixListsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.ListsPresenter;
import org.dominokit.demo.samples.presenters.components.ListsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.lists.BrixListsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ListsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixListsPresenterModule_.class,
        BrixListsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ListsComponent
    extends IsBrixComponent, HasPresenterProvider<ListsPresenterProvider> {

  ComponentProvider<ListsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ListsComponent newInstance() {
          return DaggerListsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
