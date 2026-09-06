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
import org.dominokit.demo.samples.presenters.blueprints.BrixLogExplorerPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.LogExplorerPresenter;
import org.dominokit.demo.samples.presenters.blueprints.LogExplorerPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.operationsMonitoringAndExceptionHandling.BrixLogExplorerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = LogExplorerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixLogExplorerPresenterModule_.class,
        BrixLogExplorerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface LogExplorerComponent
    extends IsBrixComponent, HasPresenterProvider<LogExplorerPresenterProvider> {

  ComponentProvider<LogExplorerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected LogExplorerComponent newInstance() {
          return DaggerLogExplorerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
