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
import org.dominokit.demo.samples.presenters.blueprints.BrixPersonalProductivityDashboardPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.PersonalProductivityDashboardPresenter;
import org.dominokit.demo.samples.presenters.blueprints.PersonalProductivityDashboardPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens.BrixPersonalProductivityDashboardViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = PersonalProductivityDashboardPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixPersonalProductivityDashboardPresenterModule_.class,
        BrixPersonalProductivityDashboardViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface PersonalProductivityDashboardComponent
    extends IsBrixComponent, HasPresenterProvider<PersonalProductivityDashboardPresenterProvider> {

  ComponentProvider<PersonalProductivityDashboardComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected PersonalProductivityDashboardComponent newInstance() {
          return DaggerPersonalProductivityDashboardComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
