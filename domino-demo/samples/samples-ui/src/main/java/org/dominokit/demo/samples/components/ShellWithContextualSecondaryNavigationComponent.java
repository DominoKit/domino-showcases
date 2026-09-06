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
import org.dominokit.demo.samples.presenters.blueprints.BrixShellWithContextualSecondaryNavigationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ShellWithContextualSecondaryNavigationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ShellWithContextualSecondaryNavigationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation.BrixShellWithContextualSecondaryNavigationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ShellWithContextualSecondaryNavigationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixShellWithContextualSecondaryNavigationPresenterModule_.class,
        BrixShellWithContextualSecondaryNavigationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ShellWithContextualSecondaryNavigationComponent
    extends IsBrixComponent, HasPresenterProvider<ShellWithContextualSecondaryNavigationPresenterProvider> {

  ComponentProvider<ShellWithContextualSecondaryNavigationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ShellWithContextualSecondaryNavigationComponent newInstance() {
          return DaggerShellWithContextualSecondaryNavigationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
