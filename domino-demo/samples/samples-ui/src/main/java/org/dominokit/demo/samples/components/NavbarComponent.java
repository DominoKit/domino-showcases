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
import org.dominokit.demo.samples.presenters.components.BrixNavbarPresenterModule_;
import org.dominokit.demo.samples.presenters.components.NavbarPresenter;
import org.dominokit.demo.samples.presenters.components.NavbarPresenterProvider;
import org.dominokit.demo.samples.ui.views.components.navbar.BrixNavbarViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = NavbarPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixNavbarPresenterModule_.class,
        BrixNavbarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface NavbarComponent
    extends IsBrixComponent, HasPresenterProvider<NavbarPresenterProvider> {

  ComponentProvider<NavbarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected NavbarComponent newInstance() {
          return DaggerNavbarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
