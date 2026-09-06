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
import org.dominokit.demo.samples.presenters.blueprints.BrixDashboardsAndOverviewScreensPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DashboardsAndOverviewScreensPresenter;
import org.dominokit.demo.samples.presenters.blueprints.DashboardsAndOverviewScreensPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens.BrixDashboardsAndOverviewScreensViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DashboardsAndOverviewScreensPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
      BrixDashboardsAndOverviewScreensPresenterModule_.class,
      BrixDashboardsAndOverviewScreensViewModule_.class,
      CoreComponentModule.class
    })
@Singleton
public interface DashboardsAndOverviewScreensComponent
    extends IsBrixComponent, HasPresenterProvider<DashboardsAndOverviewScreensPresenterProvider> {

  ComponentProvider<DashboardsAndOverviewScreensComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DashboardsAndOverviewScreensComponent newInstance() {
          return DaggerDashboardsAndOverviewScreensComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
