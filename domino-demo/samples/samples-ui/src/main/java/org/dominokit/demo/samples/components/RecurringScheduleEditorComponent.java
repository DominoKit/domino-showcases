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
import org.dominokit.demo.samples.presenters.blueprints.BrixRecurringScheduleEditorPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.RecurringScheduleEditorPresenter;
import org.dominokit.demo.samples.presenters.blueprints.RecurringScheduleEditorPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixRecurringScheduleEditorViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = RecurringScheduleEditorPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixRecurringScheduleEditorPresenterModule_.class,
        BrixRecurringScheduleEditorViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface RecurringScheduleEditorComponent
    extends IsBrixComponent, HasPresenterProvider<RecurringScheduleEditorPresenterProvider> {

  ComponentProvider<RecurringScheduleEditorComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected RecurringScheduleEditorComponent newInstance() {
          return DaggerRecurringScheduleEditorComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
