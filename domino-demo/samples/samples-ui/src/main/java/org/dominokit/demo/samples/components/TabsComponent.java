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
import org.dominokit.demo.samples.presenters.components.BrixTabsPresenterModule_;
import org.dominokit.demo.samples.presenters.components.TabsPresenter;
import org.dominokit.demo.samples.presenters.components.TabsPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.tabs.BrixTabsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TabsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTabsPresenterModule_.class,
        BrixTabsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TabsComponent
    extends IsBrixComponent, HasPresenterProvider<TabsPresenterProvider> {

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
