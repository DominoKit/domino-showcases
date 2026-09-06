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
import org.dominokit.demo.samples.presenters.blueprints.BrixSplitViewNavigationShellPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SplitViewNavigationShellPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SplitViewNavigationShellPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.pageLayoutAndNavigation.BrixSplitViewNavigationShellViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SplitViewNavigationShellPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSplitViewNavigationShellPresenterModule_.class,
        BrixSplitViewNavigationShellViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SplitViewNavigationShellComponent
    extends IsBrixComponent, HasPresenterProvider<SplitViewNavigationShellPresenterProvider> {

  ComponentProvider<SplitViewNavigationShellComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SplitViewNavigationShellComponent newInstance() {
          return DaggerSplitViewNavigationShellComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
