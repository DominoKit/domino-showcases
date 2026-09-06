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
import org.dominokit.demo.samples.presenters.blueprints.BrixTimelinePlannerWithDependenciesPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.TimelinePlannerWithDependenciesPresenter;
import org.dominokit.demo.samples.presenters.blueprints.TimelinePlannerWithDependenciesPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixTimelinePlannerWithDependenciesViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = TimelinePlannerWithDependenciesPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixTimelinePlannerWithDependenciesPresenterModule_.class,
        BrixTimelinePlannerWithDependenciesViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface TimelinePlannerWithDependenciesComponent
    extends IsBrixComponent, HasPresenterProvider<TimelinePlannerWithDependenciesPresenterProvider> {

  ComponentProvider<TimelinePlannerWithDependenciesComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected TimelinePlannerWithDependenciesComponent newInstance() {
          return DaggerTimelinePlannerWithDependenciesComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
