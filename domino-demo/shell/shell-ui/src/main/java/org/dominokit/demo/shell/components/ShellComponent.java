package org.dominokit.demo.shell.components;

import org.dominokit.demo.shell.presenters.shell.BrixShellPresenterModule_;
import org.dominokit.demo.shell.presenters.shell.ShellPresenter;
import org.dominokit.demo.shell.presenters.shell.ShellPresenterProvider;
import org.dominokit.demo.shell.ui.views.shell.BrixShellViewModule_;
import dagger.Component;
import javax.inject.Singleton;
import org.dominokit.brix.Brix;
import org.dominokit.brix.CoreComponentModule;
import org.dominokit.brix.CoreComponentModule_Factory;
import org.dominokit.brix.HasPresenterProvider;
import org.dominokit.brix.annotations.BrixComponent;
import org.dominokit.brix.api.ComponentProvider;
import org.dominokit.brix.api.IsBrixComponent;

@BrixComponent(presenter = ShellPresenter.class)
@Component(
    modules = {
        BrixShellPresenterModule_.class,
        BrixShellViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ShellComponent
    extends IsBrixComponent, HasPresenterProvider<ShellPresenterProvider> {

  ComponentProvider<ShellComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ShellComponent newInstance() {
          return DaggerShellComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
