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
import org.dominokit.demo.samples.presenters.blueprints.BrixSchedulingCalendarsAndResourcePlanningPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SchedulingCalendarsAndResourcePlanningPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SchedulingCalendarsAndResourcePlanningPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixSchedulingCalendarsAndResourcePlanningViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SchedulingCalendarsAndResourcePlanningPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixSchedulingCalendarsAndResourcePlanningPresenterModule_.class,
      BrixSchedulingCalendarsAndResourcePlanningViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface SchedulingCalendarsAndResourcePlanningComponent
    extends IsBrixComponent, HasPresenterProvider<SchedulingCalendarsAndResourcePlanningPresenterProvider> {

  ComponentProvider<SchedulingCalendarsAndResourcePlanningComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SchedulingCalendarsAndResourcePlanningComponent newInstance() {
          return DaggerSchedulingCalendarsAndResourcePlanningComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
