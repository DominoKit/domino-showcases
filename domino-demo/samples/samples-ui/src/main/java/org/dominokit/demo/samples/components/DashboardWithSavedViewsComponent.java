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
import org.dominokit.demo.samples.presenters.blueprints.BrixDashboardWithSavedViewsPresenterModule_;
import org.dominokit.demo.samples.presenters.blueprints.DashboardWithSavedViewsPresenter;
import org.dominokit.demo.samples.presenters.blueprints.DashboardWithSavedViewsPresenterProvider;
import org.dominokit.demo.samples.ui.views.blueprints.dashboardsAndOverviewScreens.BrixDashboardWithSavedViewsViewModule_;
import org.dominokit.demo.shell.components.ShellComponent;

@BrixComponent(presenter = DashboardWithSavedViewsPresenter.class, parent = ShellComponent.class)
@Component(
    modules = {
        BrixDashboardWithSavedViewsPresenterModule_.class,
        BrixDashboardWithSavedViewsViewModule_.class,
        CoreComponentModule.class
    })
@Singleton
public interface DashboardWithSavedViewsComponent
    extends IsBrixComponent, HasPresenterProvider<DashboardWithSavedViewsPresenterProvider> {

  ComponentProvider<DashboardWithSavedViewsComponent> PROVIDER =
      new ComponentProvider<>() {
        @Override
        protected DashboardWithSavedViewsComponent newInstance() {
          return DaggerDashboardWithSavedViewsComponent.builder()
              .coreComponentModule(
                  CoreComponentModule_Factory.newInstance(Brix.get().getCoreComponent()))
              .build();
        }
      };
}
