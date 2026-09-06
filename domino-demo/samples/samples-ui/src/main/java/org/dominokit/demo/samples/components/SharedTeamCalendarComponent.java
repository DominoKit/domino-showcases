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
import org.dominokit.demo.samples.presenters.blueprints.BrixSharedTeamCalendarPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.SharedTeamCalendarPresenter;
import org.dominokit.demo.samples.presenters.blueprints.SharedTeamCalendarPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixSharedTeamCalendarViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = SharedTeamCalendarPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixSharedTeamCalendarPresenterModule_.class,
        BrixSharedTeamCalendarViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface SharedTeamCalendarComponent
    extends IsBrixComponent, HasPresenterProvider<SharedTeamCalendarPresenterProvider> {

  ComponentProvider<SharedTeamCalendarComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected SharedTeamCalendarComponent newInstance() {
          return DaggerSharedTeamCalendarComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
