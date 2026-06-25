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
import org.dominokit.demo.samples.presenters.components.BrixMenuBarPresenterModule_;
import org.dominokit.demo.samples.presenters.components.MenuBarPresenter;
import org.dominokit.demo.samples.presenters.components.MenuBarPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.menubar.BrixMenuBarViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = MenuBarPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixMenuBarPresenterModule_.class,
        BrixMenuBarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface MenuBarComponent
    extends IsBrixComponent, HasPresenterProvider<MenuBarPresenterProvider> {

  ComponentProvider<MenuBarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected MenuBarComponent newInstance() {
          return DaggerMenuBarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
