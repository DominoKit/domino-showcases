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
import org.dominokit.demo.samples.presenters.blueprints.BrixApplicationFoundationsAndNavigationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ApplicationFoundationsAndNavigationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ApplicationFoundationsAndNavigationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation.BrixApplicationFoundationsAndNavigationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ApplicationFoundationsAndNavigationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixApplicationFoundationsAndNavigationPresenterModule_.class,
      BrixApplicationFoundationsAndNavigationViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface ApplicationFoundationsAndNavigationComponent
    extends IsBrixComponent, HasPresenterProvider<ApplicationFoundationsAndNavigationPresenterProvider> {

  ComponentProvider<ApplicationFoundationsAndNavigationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ApplicationFoundationsAndNavigationComponent newInstance() {
          return DaggerApplicationFoundationsAndNavigationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
