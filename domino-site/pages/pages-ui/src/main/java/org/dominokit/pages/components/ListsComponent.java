package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixListsProxyModule_;
import org.dominokit.pages.presenters.samples.components.ListsProxy;
import org.dominokit.pages.presenters.samples.components.ListsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.lists.BrixListsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ListsProxy.class)
@Component(
    modules = {
        BrixListsProxyModule_.class,
        BrixListsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ListsComponent
    extends IsBrixComponent, HasPresenterProvider<ListsProxyProvider> {

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
