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
import org.dominokit.demo.samples.presenters.blueprints.BrixPageWithPersistentNavigationPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.PageWithPersistentNavigationPresenter;
import org.dominokit.demo.samples.presenters.blueprints.PageWithPersistentNavigationPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation.BrixPageWithPersistentNavigationViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = PageWithPersistentNavigationPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixPageWithPersistentNavigationPresenterModule_.class,
        BrixPageWithPersistentNavigationViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PageWithPersistentNavigationComponent
    extends IsBrixComponent, HasPresenterProvider<PageWithPersistentNavigationPresenterProvider> {

  ComponentProvider<PageWithPersistentNavigationComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PageWithPersistentNavigationComponent newInstance() {
          return DaggerPageWithPersistentNavigationComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
