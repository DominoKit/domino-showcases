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
import org.dominokit.demo.samples.presenters.blueprints.BrixFullScreenFocusedTaskShellPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.FullScreenFocusedTaskShellPresenter;
import org.dominokit.demo.samples.presenters.blueprints.FullScreenFocusedTaskShellPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.applicationFoundationsAndNavigation.BrixFullScreenFocusedTaskShellViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = FullScreenFocusedTaskShellPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixFullScreenFocusedTaskShellPresenterModule_.class,
        BrixFullScreenFocusedTaskShellViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface FullScreenFocusedTaskShellComponent
    extends IsBrixComponent, HasPresenterProvider<FullScreenFocusedTaskShellPresenterProvider> {

  ComponentProvider<FullScreenFocusedTaskShellComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected FullScreenFocusedTaskShellComponent newInstance() {
          return DaggerFullScreenFocusedTaskShellComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
