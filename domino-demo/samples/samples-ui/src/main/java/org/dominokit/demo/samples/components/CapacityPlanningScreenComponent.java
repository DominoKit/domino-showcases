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
import org.dominokit.demo.samples.presenters.blueprints.BrixCapacityPlanningScreenPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.CapacityPlanningScreenPresenter;
import org.dominokit.demo.samples.presenters.blueprints.CapacityPlanningScreenPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixCapacityPlanningScreenViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = CapacityPlanningScreenPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixCapacityPlanningScreenPresenterModule_.class,
        BrixCapacityPlanningScreenViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface CapacityPlanningScreenComponent
    extends IsBrixComponent, HasPresenterProvider<CapacityPlanningScreenPresenterProvider> {

  ComponentProvider<CapacityPlanningScreenComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected CapacityPlanningScreenComponent newInstance() {
          return DaggerCapacityPlanningScreenComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
