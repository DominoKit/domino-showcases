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
import org.dominokit.demo.samples.presenters.blueprints.BrixPersonalCalendarAndAgendaPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.PersonalCalendarAndAgendaPresenter;
import org.dominokit.demo.samples.presenters.blueprints.PersonalCalendarAndAgendaPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixPersonalCalendarAndAgendaViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = PersonalCalendarAndAgendaPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixPersonalCalendarAndAgendaPresenterModule_.class,
        BrixPersonalCalendarAndAgendaViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PersonalCalendarAndAgendaComponent
    extends IsBrixComponent, HasPresenterProvider<PersonalCalendarAndAgendaPresenterProvider> {

  ComponentProvider<PersonalCalendarAndAgendaComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PersonalCalendarAndAgendaComponent newInstance() {
          return DaggerPersonalCalendarAndAgendaComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
