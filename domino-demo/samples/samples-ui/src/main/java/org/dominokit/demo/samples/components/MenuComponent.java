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
import org.dominokit.demo.samples.presenters.components.BrixMenuPresenterModule_;
import org.dominokit.demo.samples.presenters.components.MenuPresenter;
import org.dominokit.demo.samples.presenters.components.MenuPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.menu.BrixMenuViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MenuPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMenuPresenterModule_.class,
        BrixMenuViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MenuComponent
    extends IsBrixComponent, HasPresenterProvider<MenuPresenterProvider> {

  ComponentProvider<MenuComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MenuComponent newInstance() {
          return DaggerMenuComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
