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
import org.dominokit.demo.samples.presenters.blueprints.BrixOperationalCommandCenterPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.OperationalCommandCenterPresenter;
import org.dominokit.demo.samples.presenters.blueprints.OperationalCommandCenterPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens.BrixOperationalCommandCenterViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = OperationalCommandCenterPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixOperationalCommandCenterPresenterModule_.class,
        BrixOperationalCommandCenterViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface OperationalCommandCenterComponent
    extends IsBrixComponent, HasPresenterProvider<OperationalCommandCenterPresenterProvider> {

  ComponentProvider<OperationalCommandCenterComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected OperationalCommandCenterComponent newInstance() {
          return DaggerOperationalCommandCenterComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
