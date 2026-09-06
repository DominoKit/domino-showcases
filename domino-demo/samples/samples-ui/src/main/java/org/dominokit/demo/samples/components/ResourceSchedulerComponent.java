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
import org.dominokit.demo.samples.presenters.blueprints.BrixResourceSchedulerPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.ResourceSchedulerPresenter;
import org.dominokit.demo.samples.presenters.blueprints.ResourceSchedulerPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.schedulingCalendarsAndResourcePlanning.BrixResourceSchedulerViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = ResourceSchedulerPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixResourceSchedulerPresenterModule_.class,
        BrixResourceSchedulerViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface ResourceSchedulerComponent
    extends IsBrixComponent, HasPresenterProvider<ResourceSchedulerPresenterProvider> {

  ComponentProvider<ResourceSchedulerComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected ResourceSchedulerComponent newInstance() {
          return DaggerResourceSchedulerComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
