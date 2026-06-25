package org.dominokit.pages.components;

import org.dominokit.pages.presenters.samples.components.BrixTabsProxyModule_;
import org.dominokit.pages.presenters.samples.components.TabsProxy;
import org.dominokit.pages.presenters.samples.components.TabsProxyProvider;
import org.dominokit.pages.ui.views.samples.components.tabs.BrixTabsViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = TabsProxy.class)
@Component(
    modules = {
        BrixTabsProxyModule_.class,
        BrixTabsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TabsComponent
    extends IsBrixComponent, HasPresenterProvider<TabsProxyProvider> {

  ComponentProvider<TabsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TabsComponent newInstance() {
          return DaggerTabsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
